
import java.awt.Color;
import javax.swing.text.DefaultHighlighter;

/**
 *
 * @author Jubin
 */
public class Disassembler {

    Assembler asm;

    public Disassembler(Assembler obj) {
        asm = obj;
    }

    Disassembler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void loadDisassembler() {
        asm.jTextAreaDisassembler.getHighlighter().removeAllHighlights();
        String s = asm.jTextAreaDisassembler.getText(), line = "";
        int selectIndex = 0;
        try {
            while (s.indexOf(":", selectIndex) != -1) {
                line = s.substring(s.indexOf(":", selectIndex) + 1, s.indexOf("\n", selectIndex) == -1 ? s.length() : s.indexOf("\n", selectIndex));
                selectIndex = line.length() + selectIndex + 2;
                if (!CRC8(line).equalsIgnoreCase("00")) {
                    asm.jTextAreaDisassembler.getHighlighter().addHighlight(selectIndex - line.length() - 2, selectIndex, new DefaultHighlighter.DefaultHighlightPainter(Color.RED));
                }
                if (line.substring(6, 8).equalsIgnoreCase("00")) {
                    for (int i = 0; i < line.substring(8, line.length() - 2).length() / 2; i++) {
                        asm.matrix.memory[asm.engine.convertToNum(line.substring(2, 6)) + i] = asm.engine.convertToNum(line.substring(8 + (i * 2), 10 + (i * 2)));
                    }
                }
            }
            disasemble();
        } catch (Exception e) {
            try {
                asm.jTextAreaDisassembler.getHighlighter().addHighlight(selectIndex - line.length(), selectIndex, new DefaultHighlighter.DefaultHighlightPainter(Color.RED));
            } catch (Exception ex) {
            }
            System.out.println(e);
        }
    }

    public void disasemble() {
        String s = "", opcode = "", temp = "";
        boolean gap = false;
        int bytes = 0, tempAddr = 0;
        for (int i = 0, j = 0; i < 0xffff; i++) {
            if (asm.matrix.memory[i] != 0) {
                if (gap) {
                    gap = false;
                    s = s + "# ORG " + asm.engine.Dec2Hex(i) + "\n";
                }
                opcode = asm.engine.S[asm.matrix.memory[i]];
                bytes = asm.engine.getBytesFromMnemonics(opcode);
                if (bytes == 1) {
                    s = s + "\t" + asm.engine.HexToMnemonic(asm.matrix.memory[i], 0x00, 0x00) + "\n";
                } else if (bytes == 2) {
                    s = s + "\t" + asm.engine.HexToMnemonic(asm.matrix.memory[i], asm.matrix.memory[i + 1], 0x00) + "\n";
                } else if (bytes == 3) {
                    tempAddr = (asm.matrix.memory[i + 2] * 256 + asm.matrix.memory[i + 1]) & 0xFFFF;
                    if (asm.matrix.memory[tempAddr] == 00 ) {
                        s = s + "\t" + asm.engine.HexToMnemonic(asm.matrix.memory[i], asm.matrix.memory[i + 1], asm.matrix.memory[i + 2]) + "\n";
                    } else {
                        temp = asm.engine.HexToMnemonic(asm.matrix.memory[i], asm.matrix.memory[i + 1], asm.matrix.memory[i + 2]);
                        temp = temp.substring(0, temp.length() - 4);
                        if (asm.matrix.label[tempAddr].equalsIgnoreCase("")) {
                            s = s + "\t" + temp + "LABEL" + j + "\n";
                            asm.matrix.label[tempAddr] = "LABEL" + j;
                            j++;
                        } else {
                            s = s + "\t" + temp + asm.matrix.label[tempAddr] + "\n";

                        }
                    }
                }
                i = i + bytes - 1;
            } else {
                gap = true;
            }

        }
        //reinsert labels
        String temp1, temp2;
        for (int i = 0; i < asm.matrix.label.length; i++) {
            if (!asm.matrix.label[i].equalsIgnoreCase("")) {
                temp = "\t"+asm.engine.HexToMnemonicWithLabel(asm.matrix.memory[i], asm.matrix.memory[i + 1], asm.matrix.memory[i + 2]) + "\n";
                tempAddr = i + asm.engine.getBytesFromMnemonics(asm.engine.S[asm.matrix.memory[i]]);
                temp = temp + "\t" + asm.engine.HexToMnemonicWithLabel(asm.matrix.memory[tempAddr], asm.matrix.memory[tempAddr + 1], asm.matrix.memory[tempAddr + 2]) + "\n";
                if (s.indexOf(temp) > 0) {
                    temp1 = s.substring(0, s.indexOf(temp));
                    temp2 = s.substring(s.indexOf(temp), s.length());
                    s = temp1 + asm.matrix.label[i].toUpperCase() + ":" + temp2;
                }
                else 
                    s = s+"\n# "+asm.matrix.label[i].toUpperCase()+" EQU " + asm.engine.Dec2Hex(i);
            }
        }
        asm.jTextAreaAssemblyLanguageEditor.setText(s);
        //System.out.println(s);
    }

    public String saveDisassembler() {
        int lastnonZero = 0x100; // 0x100 means no non zero
        String s = "", temp = "";
        for (int i = 0x0000; i <= 0xffff; i += 0x10) {
            lastnonZero = 0x100;
            for (int j = 0; j < 0x10; j++) {
                if (asm.matrix.memory[i + j] != 0) {
                    lastnonZero = j;
                }
            }

            if (lastnonZero != 0x100) {
                temp = "10" + asm.engine.Dec2Hex(i) + "00";
                for (int j = 0; j < 0x10/*=lastnonZero*/; j++) {
                    temp = temp + asm.engine.Dec2Hex2digit(asm.matrix.memory[i + j]);
                }
                s = s + ":" + temp + CRC8(temp) + "\r\n";
                temp = "";
            }

        }
        if (s.length() > 0) {
            s = s + ":00000001FF";
        }
        return s;
    }

    public String CRC8(String HEXVALUES) {
        String CRC = "00";
        int crc8 = 0x00;
        if (HEXVALUES == null) {
            return CRC;
        }
        if (HEXVALUES.length() % 2 != 0) {
            return CRC;
        }
        for (int i = 0; i < HEXVALUES.length() - 1; i += 2) {
            crc8 = (crc8 + asm.engine.Hex2Dec(HEXVALUES.substring(i, i + 2)));
            //System.out.println(HEXVALUES.substring(i, i+2));
        }
        crc8 = (0xff - (crc8 & 0xff) + 1);

        return asm.engine.Dec2Hex2digit(crc8);
    }

    public static void main(String[] args) {
        Assembler asm = new Assembler();
        Disassembler dis = new Disassembler(asm);
        //System.out.println(dis.CRC8("1000100021FCFE7723773E0021FAFE77237721FE"));
        
        //System.out.println(dis.saveDisassembler());
        dis.loadDisassembler();
    }
}
