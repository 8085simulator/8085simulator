
import java.io.*;

public class Matrix {
    int beginAddress=0,stopAddress=65535;
    int A,B,C,D,E,F,H,L,SP,PC=0;
    int D1;
    int SOD,SDE,SID,R75,R65,R55,MSE,RR75,M75,M65,M55,IE,INTR,_INTA,TRAP,HOLD,_HOLDA,_RESETIN=1,RESETOUT,IO_M,_RD,_WR;
    long  clockCycleCounter,instructionCounter;
    int temp=0;
    int memory[];
    int port[];
    int select=0;
    String[] label;
    String[][] preLabel;
    AssemblerEngine engine;
    Assembler o;
    public Matrix(Assembler o) {
        this.o=o;
        memory=new int[65536];
        port=new int[256];
        label=new String[65536];
        preLabel=new String[500][2];
        engine=new AssemblerEngine(this);
        for(int i=0;i<65536;i++){label[i]="";}
    }

     public String comment(int i)
    {   i =7;
        switch(i)
        {
            case 0:return "No Operation Performed";
            case 1:return "Register pair BC = "+engine.Dec2Hex(256*memory[PC+2]+memory[PC+1])+" H";
            case 2:return "Contents of Accumulator "+engine.Dec2Hex(A)+"H are copied to memory location "+engine.Dec2Hex(memory[B<<8+C])+"H specified by Register Pair BC";
            case 3:return "Increment resister pair BC  by 1";
            case 4:return "Register B = Register B + 1";
            case 5:return "Register B = Register B - 1";
            case 6:return "Register B = "+engine.Dec2Hex2digit(memory[PC+1]);
            case 7:return "";
            case 8:return "";
            case 9:return "";
            case 10:return "";
            case 11:return "Decrement resister pair BC by 1";
            case 12:return "Register C = Register C + 1";
            case 13:return "Register C = Register C + 1";
            case 14:return "Register C = "+engine.Dec2Hex2digit(memory[PC+1]);
            case 15:return "";
            case 16:return "";
            case 17:return "Register pair DE = "+engine.Dec2Hex(256*memory[PC+2]+memory[PC+1]);
            case 18:return "";
            case 19:return "Increment resister pair DE by 1";
            case 20:return "Register D = Register D + 1";
            case 21:return "Register D = Register D - 1";
            case 22:return "Register D = "+engine.Dec2Hex2digit(memory[PC+1]);
            case 23:return "";
            case 24:return "";
            case 25:return "";
            case 26:return "";
            case 27:return "Decrement resister pair DE by 1";
            case 28:return "Register E = Register E + 1";
            case 29:return "Register E = Register E - 1";
            case 30:return "Register E = "+engine.Dec2Hex2digit(memory[PC+1]);
            case 31:return "";
            case 32:return "";
            case 33:return "Register pair HL = "+engine.Dec2Hex(256*memory[PC+2]+memory[PC+1]);
            case 34:return "";
            case 35:return "Increment resister pair HL by 1";
            case 36:return "Register H = Register H + 1";
            case 37:return "Register H = Register H - 1";
            case 38:return "Register H = "+engine.Dec2Hex2digit(memory[PC+1]);
            case 39:return "Decimal Adjust Accumulator";
            case 40:return "";
            case 41:return "";
            case 42:return "";
            case 43:return "Decrement resister pair HL by 1";
            case 44:return "Register L = Register L + 1";
            case 45:return "Register L = Register L - 1";
            case 46:return "Register L = "+engine.Dec2Hex2digit(memory[PC+1]);
            case 47:return "";
            case 48:return "";
            case 49:return "Stack Pointer(SP) = "+engine.Dec2Hex(256*memory[PC+2]+memory[PC+1]);
            case 50:return "";
            case 51:return "";
            case 52:return "Memory Content = Memory Content + 1";
            case 53:return "Memory Content = Memory Content - 1";
            case 54:return "Memory location ("+engine.Dec2Hex(256*H+L)+") = "+engine.Dec2Hex2digit(memory[PC+1]);
            case 55:return "";
            case 56:return "";
            case 57:return "";
            case 58:return "";
            case 59:return "";
            case 60:return "Accumulator = Accumulator + 1";
            case 61:return "Accumulator = Accumulator - 1";
            case 62:return "Accumulator = "+engine.Dec2Hex2digit(memory[PC+1]);
            case 63:return "";
            case 64:return "Register B = Register B";
            case 65:return "Register B = Register C";
            case 66:return "Register B = Register D";
            case 67:return "Register B = Register E";
            case 68:return "Register B = Register H";
            case 69:return "Register B = Register L";
            case 70:return "Register B = "+memory[256*H+L]+" (Content at memory location "+engine.Dec2Hex(256*H+L)+")" ;
            case 71:return "Register B = Accumulator";
            case 72:return "Register C = Register B";
            case 73:return "Register C = Register C";
            case 74:return "Register C = Register D";
            case 75:return "Register C = Register E";
            case 76:return "Register C = Register H";
            case 77:return "Register C = Register L";
            case 78:return "Register C = "+memory[256*H+L]+" (Content at memory location "+engine.Dec2Hex(256*H+L)+")";
            case 79:return "Register C = Accumulator";
            case 80:return "Register D = Register B";
            case 81:return "Register D = Register C";
            case 82:return "Register D = Register D";
            case 83:return "Register D = Register E";
            case 84:return "Register D = Register H";
            case 85:return "Register D = Register L";
            case 86:return "Register D = "+memory[256*H+L]+" (Content at memory location "+engine.Dec2Hex(256*H+L)+")";
            case 87:return "Register D = Accumulator";
            case 88:return "Register E = Register B";
            case 89:return "Register E = Register C";
            case 90:return "Register E = Register D";
            case 91:return "Register E = Register E";
            case 92:return "Register E = Register H";
            case 93:return "Register E = Register L";
            case 94:return "Register E = "+memory[256*H+L]+" (Content at memory location "+engine.Dec2Hex(256*H+L)+")";
            case 95:return "Register E = Accumulator";
            case 96:return "Register H = Register B";
            case 97:return "Register H = Register C";
            case 98:return "Register H = Register D";
            case 99:return "Register H = Register E";
            case 100:return "Register H = Register H";
            case 101:return "Register H = Register L";
            case 102:return "Register H = "+memory[256*H+L]+" (Content at memory location "+engine.Dec2Hex(256*H+L)+")";
            case 103:return "Register H = Accumulator";
            case 104:return "Register L = Register B";
            case 105:return "Register L = Register C";
            case 106:return "Register L = Register D";
            case 107:return "Register L = Register E";
            case 108:return "Register L = Register H";
            case 109:return "Register L = Register L";
            case 110:return "Register L = "+memory[256*H+L]+" (Content at memory location "+engine.Dec2Hex(256*H+L)+")";
            case 111:return "Register L = Accumulator";
            case 112:return "Memory location ("+engine.Dec2Hex(256*H+L)+") = Register B";
            case 113:return "Memory location ("+engine.Dec2Hex(256*H+L)+") = Register C";
            case 114:return "Memory location ("+engine.Dec2Hex(256*H+L)+") = Register D";
            case 115:return "Memory location ("+engine.Dec2Hex(256*H+L)+") = Register E";
            case 116:return "Memory location ("+engine.Dec2Hex(256*H+L)+") = Register H";
            case 117:return "Memory location ("+engine.Dec2Hex(256*H+L)+") = Register L";
            case 118:return "Halt";
            case 119:return "Memory location ("+engine.Dec2Hex(256*H+L)+") = Accumulator";
            case 120:return "Accumulator = Register B";
            case 121:return "Accumulator = Register C";
            case 122:return "Accumulator = Register D";
            case 123:return "Accumulator = Register E";
            case 124:return "Accumulator = Register H";
            case 125:return "Accumulator = Register L";
            case 126:return "Accumulator = "+memory[256*H+L]+" (Content at memory location "+engine.Dec2Hex(256*H+L)+")";
            case 127:return "Accumulator = Accumulator";
            case 128:return "Accumulator=Accumulator + Register B";
            case 129:return "Accumulator=Accumulator + Register C";
            case 130:return "Accumulator=Accumulator + Register D";
            case 131:return "Accumulator=Accumulator + Register E";
            case 132:return "Accumulator=Accumulator + Register H";
            case 133:return "Accumulator=Accumulator + Register L";
            case 134:return "Accumulator=Accumulator + "+memory[256*H+L]+" (Content at memory location "+engine.Dec2Hex(256*H+L)+")";
            case 135:return "Accumulator=Accumulator + Accumulator";
            case 136:return "Accumulator=Accumulator + Register B + Carry";
            case 137:return "Accumulator=Accumulator + Register C + Carry";
            case 138:return "Accumulator=Accumulator + Register D + Carry";
            case 139:return "Accumulator=Accumulator + Register E + Carry";
            case 140:return "Accumulator=Accumulator + Register H + Carry";
            case 141:return "Accumulator=Accumulator + Register L + Carry";
            case 142:return "Accumulator=Accumulator + "+memory[256*H+L]+" (Content at memory location "+engine.Dec2Hex(256*H+L)+") + Carry";
            case 143:return "Accumulator=Accumulator + Accumulator + Carry";
            case 144:return "";
            case 145:return "";
            case 146:return "";
            case 147:return "";
            case 148:return "";
            case 149:return "";
            case 150:return "";
            case 151:return "";
            case 152:return "";
            case 153:return "";
            case 154:return "";
            case 155:return "";
            case 156:return "";
            case 157:return "";
            case 158:return "";
            case 159:return "";
            case 160:return "Lgically AND the contents of register B with the contents of Accumulator";
            case 161:return "";
            case 162:return "";
            case 163:return "";
            case 164:return "";
            case 165:return "";
            case 166:return "";
            case 167:return "";
            case 168:return "";
            case 169:return "";
            case 170:return "";
            case 171:return "";
            case 172:return "";
            case 173:return "";
            case 174:return "";
            case 175:return "";
            case 176:return "";
            case 177:return "";
            case 178:return "";
            case 179:return "";
            case 180:return "";
            case 181:return "";
            case 182:return "";
            case 183:return "";
            case 184:return "";
            case 185:return "";
            case 186:return "";
            case 187:return "";
            case 188:return "";
            case 189:return "";
            case 190:return "";
            case 191:return "";
            case 192:return "";
            case 193:return "";
            case 194:return "Jump on No Zero to memory location "+engine.Dec2Hex(memory[PC+2]*256+memory[PC+1])+" [zero = "+((F&64)/64)+"]";
            case 195:return "Jump to memory location "+engine.Dec2Hex(memory[PC+2]*256+memory[PC+1]);
            case 196:return "";
            case 197:return "";
            case 198:return "Add "+engine.Dec2Hex2digit(memory[PC+1])+" to Accumulator";
            case 199:return "Restart from memory address "+engine.Dec2Hex(beginAddress+0)+" [Interrupt = "+(o.stopAtIndex==199)+"]";
            case 200:return "";
            case 201:return "";
            case 202:return "Jump on Zero to memory location "+engine.Dec2Hex(memory[PC+2]*256+memory[PC+1])+" [zero = "+((F&64)/64)+"]";
            case 203:return "";
            case 204:return "";
            case 205:return "";
            case 206:return "";
            case 207:return "Restart from memory address "+engine.Dec2Hex(beginAddress+8)+" [Interrupt = "+(o.stopAtIndex==207)+"]";
            case 208:return "";
            case 209:return "";
            case 210:return "Jump on No Carry to memory location "+engine.Dec2Hex(memory[PC+2]*256+memory[PC+1])+" [carry = "+(F&1)+"]";
            case 211:return "";
            case 212:return "";
            case 213:return "";
            case 214:return "";
            case 215:return "Restart from memory address "+engine.Dec2Hex(beginAddress+16)+" [Interrupt = "+(o.stopAtIndex==215)+"]";
            case 216:return "";
            case 217:return "";
            case 218:return "Jump on Carry to memory location "+engine.Dec2Hex(memory[PC+2]*256+memory[PC+1])+" [carry = "+(F&1)+"]";
            case 219:return "";
            case 220:return "";
            case 221:return "";
            case 222:return "";
            case 223:return "Restart from memory address "+engine.Dec2Hex(beginAddress+24)+" [Interrupt = "+(o.stopAtIndex==223)+"]";
            case 224:return "";
            case 225:return "";
            case 226:return "Jump on Parity Odd to memory location "+engine.Dec2Hex(memory[PC+2]*256+memory[PC+1])+" [parity = "+((F&4)/4)+"]";
            case 227:return "";
            case 228:return "";
            case 229:return "";
            case 230:return "";
            case 231:return "Restart from memory address "+engine.Dec2Hex(beginAddress+32)+" [Interrupt = "+(o.stopAtIndex==231)+"]";
            case 232:return "";
            case 233:return "";
            case 234:return "Jump on Parity Even to memory location "+engine.Dec2Hex(memory[PC+2]*256+memory[PC+1])+" [parity = "+((F&4)/4)+"]";
            case 235:return "";
            case 236:return "";
            case 237:return "";
            case 238:return "";
            case 239:return "Restart from memory address "+engine.Dec2Hex(beginAddress+40)+" [Interrupt = "+(o.stopAtIndex==239)+"]";
            case 240:return "";
            case 241:return "";
            case 242:return "Jump on Positive to memory location "+engine.Dec2Hex(memory[PC+2]*256+memory[PC+1])+" [sign = "+((F&128)/128)+"]";
            case 243:return "";
            case 244:return "";
            case 245:return "";
            case 246:return "";
            case 247:return "Restart from memory address "+engine.Dec2Hex(beginAddress+48)+" [Interrupt = "+(o.stopAtIndex==247)+"]";
            case 248:return "";
            case 249:return "";
            case 250:return "Jump on Negative to memory location "+engine.Dec2Hex(memory[PC+2]*256+memory[PC+1])+" [sign = "+((F&128)/128)+"]";
            case 251:return "";
            case 252:return "";
            case 253:return "";
            case 254:return "";
            case 255:return "Restart from memory address "+engine.Dec2Hex(beginAddress+56)+" [Interrupt = "+(o.stopAtIndex==255)+"]";

  }
        return "";
    }

    public String tstates(int n) {
        switch (n) {
            case 0:
                return "F";
            case 1:
                return "FRR";
            case 2:
                return "FW";
            case 3:
                return "S";
            case 4:
                return "F";
            case 5:
                return "F";
            case 6:
                return "FR";
            case 7:
                return "F";
            case 8:
                return "F";
            case 9:
                return "FBB";
            case 10:
                return "FR";
            case 11:
                return "S";
            case 12:
                return "F";
            case 13:
                return "F";
            case 14:
                return "FR";
            case 15:
                return "F";
            case 16:
                return "F";
            case 17:
                return "FRR";
            case 18:
                return "FW";
            case 19:
                return "S";
            case 20:
                return "F";
            case 21:
                return "F";
            case 22:
                return "FR";
            case 23:
                return "F";
            case 24:
                return "F";
            case 25:
                return "FBB";
            case 26:
                return "FR";
            case 27:
                return "S";
            case 28:
                return "F";
            case 29:
                return "F";
            case 30:
                return "FR";
            case 31:
                return "F";
            case 32:
                return "F";
            case 33:
                return "FRR";
            case 34:
                return "FRRWW";
            case 35:
                return "S";
            case 36:
                return "F";
            case 37:
                return "F";
            case 38:
                return "FR";
            case 39:
                return "F";
            case 40:
                return "F";
            case 41:
                return "FBB";
            case 42:
                return "FRRRR";
            case 43:
                return "S";
            case 44:
                return "F";
            case 45:
                return "F";
            case 46:
                return "FR";
            case 47:
                return "F";
            case 48:
                return "F";
            case 49:
                return "FRR";
            case 50:
                return "FRRW";
            case 51:
                return "S";
            case 52:
                return "FRW";
            case 53:
                return "FRW";
            case 54:
                return "FRW";
            case 55:
                return "F";
            case 56:
                return "F";
            case 57:
                return "FBB";
            case 58:
                return "FRRR";
            case 59:
                return "S";
            case 60:
                return "F";
            case 61:
                return "F";
            case 62:
                return "FR";
            case 63:
                return "F";
            case 64:
                return "F";
            case 65:
                return "F";
            case 66:
                return "F";
            case 67:
                return "F";
            case 68:
                return "F";
            case 69:
                return "F";
            case 70:
                return "FR";
            case 71:
                return "F";
            case 72:
                return "F";
            case 73:
                return "F";
            case 74:
                return "F";
            case 75:
                return "F";
            case 76:
                return "F";
            case 77:
                return "F";
            case 78:
                return "FR";
            case 79:
                return "F";
            case 80:
                return "F";
            case 81:
                return "F";
            case 82:
                return "F";
            case 83:
                return "F";
            case 84:
                return "F";
            case 85:
                return "F";
            case 86:
                return "FR";
            case 87:
                return "F";
            case 88:
                return "F";
            case 89:
                return "F";
            case 90:
                return "F";
            case 91:
                return "F";
            case 92:
                return "F";
            case 93:
                return "F";
            case 94:
                return "FR";
            case 95:
                return "F";
            case 96:
                return "F";
            case 97:
                return "F";
            case 98:
                return "F";
            case 99:
                return "F";
            case 100:
                return "F";
            case 101:
                return "F";
            case 102:
                return "FR";
            case 103:
                return "F";
            case 104:
                return "F";
            case 105:
                return "F";
            case 106:
                return "F";
            case 107:
                return "F";
            case 108:
                return "F";
            case 109:
                return "F";
            case 110:
                return "FR";
            case 111:
                return "F";
            case 112:
                return "FW";
            case 113:
                return "FW";
            case 114:
                return "FW";
            case 115:
                return "FW";
            case 116:
                return "FW";
            case 117:
                return "FW";
            case 118:
                return "FB";
            case 119:
                return "FW";
            case 120:
                return "F";
            case 121:
                return "F";
            case 122:
                return "F";
            case 123:
                return "F";
            case 124:
                return "F";
            case 125:
                return "F";
            case 126:
                return "FR";
            case 127:
                return "F";
            case 128:
                return "F";
            case 129:
                return "F";
            case 130:
                return "F";
            case 131:
                return "F";
            case 132:
                return "F";
            case 133:
                return "F";
            case 134:
                return "FR";
            case 135:
                return "F";
            case 136:
                return "F";
            case 137:
                return "F";
            case 138:
                return "F";
            case 139:
                return "F";
            case 140:
                return "F";
            case 141:
                return "F";
            case 142:
                return "FR";
            case 143:
                return "F";
            case 144:
                return "F";
            case 145:
                return "F";
            case 146:
                return "F";
            case 147:
                return "F";
            case 148:
                return "F";
            case 149:
                return "F";
            case 150:
                return "FR";
            case 151:
                return "F";
            case 152:
                return "F";
            case 153:
                return "F";
            case 154:
                return "F";
            case 155:
                return "F";
            case 156:
                return "F";
            case 157:
                return "F";
            case 158:
                return "FR";
            case 159:
                return "F";
            case 160:
                return "F";
            case 161:
                return "F";
            case 162:
                return "F";
            case 163:
                return "F";
            case 164:
                return "F";
            case 165:
                return "F";
            case 166:
                return "FR";
            case 167:
                return "F";
            case 168:
                return "F";
            case 169:
                return "F";
            case 170:
                return "F";
            case 171:
                return "F";
            case 172:
                return "F";
            case 173:
                return "F";
            case 174:
                return "FR";
            case 175:
                return "F";
            case 176:
                return "F";
            case 177:
                return "F";
            case 178:
                return "F";
            case 179:
                return "F";
            case 180:
                return "F";
            case 181:
                return "F";
            case 182:
                return "FR";
            case 183:
                return "F";
            case 184:
                return "F";
            case 185:
                return "F";
            case 186:
                return "F";
            case 187:
                return "F";
            case 188:
                return "F";
            case 189:
                return "F";
            case 190:
                return "FR";
            case 191:
                return "F";
            case 192:
                return "SRR";
            case 193:
                return "FRR";
            case 194:
                return "FRR";
            case 195:
                return "FRR";
            case 196:
                return "SRRWW";
            case 197:
                return "SWW";
            case 198:
                return "FR";
            case 199:
                return "SWW";
            case 200:
                return "SRR";
            case 201:
                return "SRR";
            case 202:
                return "FRR";
            case 203:
                return "F";
            case 204:
                return "SRRWW";
            case 205:
                return "SRRWW";
            case 206:
                return "FR";
            case 207:
                return "SWW";
            case 208:
                return "SRR";
            case 209:
                return "FRR";
            case 210:
                return "FRR";
            case 211:
                return "FRO";
            case 212:
                return "SRRWW";
            case 213:
                return "SWW";
            case 214:
                return "FR";
            case 215:
                return "SWW";
            case 216:
                return "SRR";
            case 217:
                return "F";
            case 218:
                return "FRR";
            case 219:
                return "FRI";
            case 220:
                return "SRRWW";
            case 221:
                return "F";
            case 222:
                return "FR";
            case 223:
                return "SWW";
            case 224:
                return "SRR";
            case 225:
                return "FRR";
            case 226:
                return "FRR";
            case 227:
                return "FRRWW";
            case 228:
                return "SRRWW";
            case 229:
                return "SWW";
            case 230:
                return "FR";
            case 231:
                return "SWW";
            case 232:
                return "SRR";
            case 233:
                return "S";
            case 234:
                return "FRR";
            case 235:
                return "F";
            case 236:
                return "SRRWW";
            case 237:
                return "F";
            case 238:
                return "FR";
            case 239:
                return "SWW";
            case 240:
                return "SRR";
            case 241:
                return "FRR";
            case 242:
                return "FRR";
            case 243:
                return "F";
            case 244:
                return "SRRWW";
            case 245:
                return "SWW";
            case 246:
                return "FR";
            case 247:
                return "SWW";
            case 248:
                return "SRR";
            case 249:
                return "S";
            case 250:
                return "FRR";
            case 251:
                return "F";
            case 252:
                return "SRRWW";
            case 253:
                return "F";
            case 254:
                return "FR";
            case 255:
                return "SWW";
            default: return "0";
        }
    }


    public void createCopy(Matrix x)
    {
        try {
                    File f=new File("cache");
                    f.mkdir();
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cache"+o.fileSeparator+o.oIndex+".tmp")));
                    out.println(x.A);out.println(x.F);
                    out.println(x.B);out.println(x.C);
                    out.println(x.D);out.println(x.E);
                    out.println(x.H);out.println(x.L);
                    out.println(x.SP);out.println(x.PC);
                    out.println(x.D1);
                    out.println(x.clockCycleCounter);out.println(x.instructionCounter);
                    out.println(x.SOD);out.println(x.SDE);out.println(x.SID);out.println(x.R75);out.println(x.R65);out.println(x.R55);out.println(x.MSE);out.println(x.M75);out.println(x.M65);out.println(x.M55);out.println(x.IE);out.println(x.INTR);out.println(x._INTA);out.println(x.TRAP);
                    out.println(x.beginAddress);out.println(x.stopAddress);
                    for(int i=0;i<65536;i++)
                    {
                    out.println(x.memory[i]);
                    out.println(x.label[i]);
                    }
                    for(int i=0;i<256;i++)
                    {
                        out.println(x.port[i]);
                    }
                    out.println(x.select);
                    out.close();
                } catch (Exception e) {
                    Popup.show("Unable to create backward step instances.");
                }

        /*Matrix m=new Matrix(o);
        m.A=x.A;m.F=x.F;
        m.B=x.B;m.C=x.C;
        m.D=x.D;m.E=x.E;
        m.H=x.H;m.L=x.L;
        m.SP=x.SP;
        m.PC=x.PC;m.clockCycleCounter=x.clockCycleCounter;m.instructionCounter=x.instructionCounter;
        m.SOD=x.SOD;m.SDE=x.SDE;m.SID=x.SID;m.R75=x.R75;m.R65=x.R65;m.R55=x.R55;m.MSE=x.MSE;m.M75=x.M75;m.M65=x.M65;m.M55=x.M55;m.IE=x.IE;m.INTR=x.INTR;m.INTA=x.INTA;m.TRAP=x.TRAP;
        m.beginAddress=x.beginAddress;m.stopAddress=x.stopAddress;
        for(int i=0;i<65536;i++)
        {
            m.memory[i]=x.memory[i];
            m.label[i]=x.label[i];
        }
        for(int i=0;i<256;i++)
        {
            m.port[i]=x.port[i];
        }
        return m;*/
    }

    public void readCopy(Matrix x)
    {
        try {
                    BufferedReader in=new BufferedReader(new FileReader("cache"+o.fileSeparator+o.oIndex+".tmp"));
                    x.A=Integer.parseInt(in.readLine());x.F=Integer.parseInt(in.readLine());
                    x.B=Integer.parseInt(in.readLine());x.C=Integer.parseInt(in.readLine());
                    x.D=Integer.parseInt(in.readLine());x.E=Integer.parseInt(in.readLine());
                    x.H=Integer.parseInt(in.readLine());x.L=Integer.parseInt(in.readLine());
                    x.SP=Integer.parseInt(in.readLine());x.PC=Integer.parseInt(in.readLine());
                    x.D1=Integer.parseInt(in.readLine());
                    x.clockCycleCounter=Integer.parseInt(in.readLine());x.instructionCounter=Integer.parseInt(in.readLine());
                    x.SOD=Integer.parseInt(in.readLine());x.SDE=Integer.parseInt(in.readLine());x.SID=Integer.parseInt(in.readLine());x.R75=Integer.parseInt(in.readLine());x.R65=Integer.parseInt(in.readLine());x.R55=Integer.parseInt(in.readLine());x.MSE=Integer.parseInt(in.readLine());x.M75=Integer.parseInt(in.readLine());x.M65=Integer.parseInt(in.readLine());x.M55=Integer.parseInt(in.readLine());x.IE=Integer.parseInt(in.readLine());x.INTR=Integer.parseInt(in.readLine());x._INTA=Integer.parseInt(in.readLine());x.TRAP=Integer.parseInt(in.readLine());
                    x.beginAddress=Integer.parseInt(in.readLine());x.stopAddress=Integer.parseInt(in.readLine());
                    for(int i=0;i<65536;i++)
                    {
                    x.memory[i]=Integer.parseInt(in.readLine());
                    x.label[i]=in.readLine();
                    }
                    for(int i=0;i<256;i++)
                    {
                        x.port[i]=Integer.parseInt(in.readLine());
                    }
                    x.select=Integer.parseInt(in.readLine());
                    in.close();
                } catch (Exception e) {
                    o.jButtonBackward.setEnabled(false);
                }
    }
    public void functionRun(int index)
    {
        int no[];
        PC++;
        if(o.stopAtIndex==index)o.stop=true;
        switch(index)
        {
            case 0://NOP
                    break;

            case 1://LXI B
                   C=memory[PC++];
                   B=memory[PC++];
                   break;
            case 2://STAX B
                    memory[B<<8+C]=A;
                    break;
            case 3://INX B
                   temp=B<<8 | C;
                   temp++;
                   B=(temp>>8)&0xff; C=temp&0x00ff;
                    break;
            case 4://INR B
                   F=getFlagADD(B,0x01)&0xFE | F&0x01;
                   B=(B+1)&0xff;
                    break;
            case 5:F=getFlagADD(B,0xFF)&0xFE | F&0x01; //2's complement and carry falg not affected
                    B=(B-1)&0xff;                                      
                    break;
            case 6:B=memory[PC++];
                    break;
            case 7:temp=A/128;A=(A%128)*2+temp;
                   F=(F&254)^temp;
                    break;
            case 8:
                    break;
            case 9:H=H+B;L=L+C;
                   if(L>255){H=H+L/256;L=L%256;}
                   if(H>255){F=(F&254)^1;H=H%256;}
                    break;
            case 10:A=memory[256*B+C];
                    break;
            case 11:C--;
                    if(((B*256)+C)<0){B=255;C=255;}
                    if(C<0){C=255;B--;}
                   break;
            case 12:
                   F=getFlagADD(C,0x01)&0xFE | F&0x01;
                    C=(C+1)&0xff;
                    break;
            case 13:F=getFlagADD(C,0xFF)&0xFE | F&0x01; 
                    C=(C-1)&0xff;                                      
                    break;
            case 14:
                    C=memory[PC++];
                    break;
            case 15:temp=A%2;A=A/2+temp*128;
                    F=(F&254)^temp;
                    break;
            case 16:
                    break;
            case 17:
                    E=memory[PC++];
                    D=memory[PC++];
                    break;
            case 18:memory[256*D+E]=A;
                    break;
            case 19:temp=D<<8 | E;
                   temp++;
                   D=(temp>>8)&0xff; E=temp&0x00ff;
                    break;
            case 20:F=getFlagADD(D,0x01)&0xFE | F&0x01;
                    D=(D+1)&0xff;
                    break;

            case 21:F=getFlagADD(D,0xFF)&0xFE | F&0x01; 
                    D=(D-1)&0xff;
                    break;
            case 22:
                    D=memory[PC++];
                    break;
            case 23:temp=A/128;A=(A%128)*2+(F&1);
                    F=(F&254)^temp;
                    break;
            case 24:
                    break;
            case 25:H=H+D;L=L+E;
                   if(L>255){H=H+L/256;L=L%256;}
                   if(H>255){F=(F&254)^1;H=H%256;}
                    break;
            case 26:A=memory[256*D+E];
                    break;
            case 27:E--;
                    if(((D*256)+E)<0){D=255;E=255;}
                    if(E<0){E=255;D--;}
                    break;
            case 28:F=getFlagADD(E,0x01)&0xFE | F&0x01;
                    E=(E+1)&0xff;
                    break;
            case 29:F=getFlagADD(E,0xFF)&0xFE | F&0x01; 
                    E=(E-1)&0xff;
                    break;
            case 30:E=memory[PC++];
                    break;

            case 31:temp=A%2;A=A/2+(F&1)*128;
                    F=(F&254)^temp;
                   break;
            case 32:A=SID*128+R75*64+R65*32+R55*16+IE*8+M75*4+M65*2+M55;
                    break;
            case 33:
                    L=memory[PC++];
                    H=memory[PC++];
                    break;
            case 34:temp=(memory[PC++]+memory[PC++]*256);
                    memory[temp]=L;
                    memory[temp+1]=H;
                    break;
            case 35:temp=H<<8 | L;
                   temp++;
                   H=(temp>>8)&0xff; L=temp&0x00ff;
                    break;
            case 36:F=getFlagADD(H,0x01)&0xFE | F&0x01;
                    H=(H+1)&0xff;
                    break;
            case 37:F=getFlagADD(H,0xFF)&0xFE | F&0x01; 
                    H=(H-1)&0xff;
                    break;
            case 38:H=memory[PC++];
                    break;
            case 39:temp=0;
                    if((A&0x0f)>0x09 || (F&0x10)==0x10) {
                        temp=0x06;
                        }
                    if((A&0xf0)>0x90 || (F&0x1)==1){
                        temp=temp+0x60;
                        }
                    F=(getFlagADD(A,temp)&0xFF)^(F&0x01);
                    A=A+temp;
                    A=A&0xff;
                    break;
            case 40:
                    break;

            case 41:H=H+H;L=L+L;
                   if(L>255){H=H+L/256;L=L%256;}
                   if(H>255){F=(F&254)^1;H=H%256;}
                    break;
            case 42:temp=(memory[PC++]+memory[PC++]*256);
                    L=memory[temp];
                    H=memory[temp+1];
                    break;
            case 43:L--;
                    if(((H*256)+L)<0){H=255;L=255;}
                    if(L<0){L=255;H--;}
                    break;
            case 44:F=getFlagADD(L,0x01)&0xFE | F&0x01;                   
                    L=(L+1)&0xff;
                    break;
            case 45:F=getFlagADD(L,0xFF)&0xFE | F&0x01; 
                    L=(L-1)&0xff;
                    break;
            case 46:L=memory[PC++];
                    break;
            case 47:A=255-A;
                    break;
            case 48:SOD=A/128;
                    SDE=(A%128)/64;
                    D1=(A%64)/32;
                    RR75=(A%32)/16;
                    MSE=(A%16)/8;
                    M75=(A%8)/4;
                    M65=(A%4)/2;
                    M55=(A%2);
                    break;
            case 49:SP=memory[PC++]+memory[PC++]*256;
                    break;
            case 50:memory[memory[PC++]+memory[PC++]*256]=A;
                    break;
            case 51:SP=(SP+1)&0xFFFF;
                   break;
            case 52:F=getFlagADD(memory[256*H+L],0x01)&0xFE | F&0x01;                    
                    memory[256*H+L]=(memory[256*H+L]+1)&0xff;
                    break;
            case 53:F=getFlagADD(memory[256*H+L],0xFF)&0xFE | F&0x01; 
                    memory[256*H+L]=(memory[256*H+L]-1)&0xff;                    
                    break;
            case 54:memory[256*H+L]=memory[PC++];
                    break;
            case 55:F=(F|1);
                    break;
            case 56:
                    break;
            case 57:H=H+(SP&240);L=L+(SP&15);
                   if(L>255){H=H+L/256;L=L%256;}
                   if(H>255){F=(F&254)^1;H=H%256;}
                   break;
            case 58:A=memory[memory[PC++]+memory[PC++]*256];
                    break;
            case 59:SP--;
                    if(SP<0)SP=stopAddress;
                    break;
            case 60:F=getFlagADD(A,0x01)&0xFE | F&0x01;
                    A=(A+1)&0xff;
                    break;
            case 61:F=getFlagADD(A,0xFF)&0xFE | F&0x01; 
                    A=(A-1)&0xff;
                   break;
            case 62:A=memory[PC++];
                    break;
            case 63:F=F^1;
                    break;
            case 64:B=B;
                    break;
            case 65:B=C;
                    break;
            case 66:B=D;
                    break;
            case 67:B=E;
                    break;
            case 68:B=H;
                    break;
            case 69:B=L;
                    break;
            case 70:B=memory[256*H+L];
                    break;
            case 71:B=A;
                   break;
            case 72:C=B;
                    break;
            case 73:C=C;
                    break;
            case 74:C=D;
                    break;
            case 75:C=E;
                    break;
            case 76:C=H;
                    break;
            case 77:C=L;
                    break;
            case 78:C=memory[256*H+L];
                    break;
            case 79:C=A;
                    break;
            case 80:D=B;
                    break;
            case 81:D=C;
                   break;
            case 82:D=D;
                    break;
            case 83:D=E;
                    break;
            case 84:D=H;
                    break;
            case 85:D=L;
                    break;
            case 86:D=memory[256*H+L];
                    break;
            case 87:D=A;
                    break;
            case 88:E=B;
                    break;
            case 89:E=C;
                    break;
            case 90:E=D;
                    break;
            case 91:E=E;
                   break;
            case 92:E=H;
                    break;
            case 93:E=L;
                    break;
            case 94:E=memory[256*H+L];
                    break;
            case 95:E=A;
                    break;
            case 96:H=B;
                    break;
            case 97:H=C;
                    break;
            case 98:H=D;
                    break;
            case 99:H=E;
                    break;
            case 100:H=H;
                    break;
            case 101:H=L;
                   break;
            case 102:H=memory[256*H+L];
                    break;
            case 103:H=A;
                    break;
            case 104:L=B;
                    break;
            case 105:L=C;
                    break;
            case 106:L=D;
                    break;
            case 107:L=E;
                    break;
            case 108:L=H;
                    break;
            case 109:L=L;
                    break;
            case 110:L=memory[256*H+L];
                    break;
            case 111:L=A;
                   break;
            case 112:memory[256*H+L]=B;
                    break;
            case 113:memory[256*H+L]=C;
                    break;
            case 114:memory[256*H+L]=D;
                    break;
            case 115:memory[256*H+L]=E;
                    break;
            case 116:memory[256*H+L]=H;
                    break;
            case 117:memory[256*H+L]=L;
                    break;
            case 118:o.stop=true;PC--;
                    break;
            case 119:memory[256*H+L]=A;
                    break;
            case 120:A=B;
                    break;
            case 121:A=C;
                   break;
            case 122:A=D;
                    break;
            case 123:A=E;
                    break;
            case 124:A=H;
                    break;
            case 125:A=L;
                    break;
            case 126:A=memory[256*H+L];
                    break;
            case 127:A=A;
                    break;
            case 128:F=getFlagADD(A, B);
                     A=A+B;
                     if(A/256>=1)A=A%256;
                    break;
            case 129:F=getFlagADD(A, C);
                     A=A+C;
                     if(A/256>=1)A=A%256;
                    break;
            case 130:F=getFlagADD(A, D);
                     A=A+D;
                     if(A/256>=1)A=A%256;
                    break;
            case 131:F=getFlagADD(A, E);
                     A=A+E;
                     if(A/256>=1)A=A%256;
                   break;
            case 132:F=getFlagADD(A, H);
                     A=A+H;
                     if(A/256>=1)A=A%256;
                    break;
            case 133:F=getFlagADD(A, L);
                     A=A+L;
                     if(A/256>=1)A=A%256;
                    break;
            case 134:F=getFlagADD(A, memory[H*256+L]);
                     A=A+memory[H*256+L];
                     if(A/256>=1)A=A%256;
                    break;
            case 135:F=getFlagADD(A, A);
                     A=A+A;
                     if(A/256>=1)A=A%256;
                    break;
            case 136:temp=F&1;
                     F=getFlagADD(A, B+temp);
                     A=A+B+temp;
                     if(A/256>=1)A=A%256;
                    break;
            case 137:temp=F&1;
                     F=getFlagADD(A, C+temp);
                     A=A+C+temp;
                     if(A/256>=1)A=A%256;
                    break;
            case 138:temp=F&1;
                     F=getFlagADD(A, D+temp);
                     A=A+D+temp;
                     if(A/256>=1)A=A%256;
                    break;
            case 139:temp=F&1;
                     F=getFlagADD(A, E+temp);
                     A=A+E+temp;
                     if(A/256>=1)A=A%256;
                    break;
            case 140:temp=F&1;
                     F=getFlagADD(A, H+temp);
                     A=A+H+temp;
                     if(A/256>=1)A=A%256;
                    break;

            case 141:temp=F&1;
                     F=getFlagADD(A, L+temp);
                     A=A+L+temp;
                     if(A/256>=1)A=A%256;
                    break;
            case 142:temp=F&1;
                     F=getFlagADD(A, memory[H*256+L]+temp);
                     A=A+memory[H*256+L]+temp;
                     if(A/256>=1)A=A%256;
                    break;
            case 143:temp=F&1;
                     F=getFlagADD(A, A+temp);
                     A=A+A+temp;
                     if(A/256>=1)A=A%256;
                    break;
            case 144:temp=_2sCompliment(B);
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 145:temp=_2sCompliment(C); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 146:temp=_2sCompliment(D);  
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 147:temp=_2sCompliment(E);  
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 148:temp=_2sCompliment(H);  
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 149:temp=_2sCompliment(L); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 150:temp=_2sCompliment(memory[H*256+L]);  
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 151:temp=_2sCompliment(A); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                   break;
            case 152:temp = B+(F&0x01);
                     temp=_2sCompliment(temp);
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 153:temp = C+(F&0x01);
                     temp=_2sCompliment(temp); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 154:temp = D+(F&0x01);
                     temp=_2sCompliment(temp); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 155:temp = E+(F&0x01);
                     temp=_2sCompliment(temp); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 156:temp = H+(F&0x01);
                     temp=_2sCompliment(temp); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 157:temp = L+(F&0x01);
                     temp=_2sCompliment(temp); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 158:temp = memory[H*256+L]+(F&0x01);
                     temp=_2sCompliment(temp); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 159:temp = A+(F&0x01);
                     temp=_2sCompliment(temp); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 160:A=(A&B);
                    F=getFlagForLogic(A, 1, 0);
                    break;
            case 161:A=(A&C);
                    F=getFlagForLogic(A, 1, 0);
                   break;
            case 162:A=(A&D);
                    F=getFlagForLogic(A, 1, 0);
                    break;
            case 163:A=(A&E);
                    F=getFlagForLogic(A, 1, 0);
                    break;
            case 164:A=(A&H);
                    F=getFlagForLogic(A, 1, 0);
                    break;
            case 165:A=(A&L);
                    F=getFlagForLogic(A, 1, 0);
                    break;
            case 166:A=(A&memory[H* 256+L]);
                    F=getFlagForLogic(A, 1, 0);
                    break;
            case 167:A=(A&A);
                    F=getFlagForLogic(A, 1, 0);
                    break;
            case 168:A=(A^B);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 169:A=(A^C);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 170:A=(A^D);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 171:A=(A^E);
                    F=getFlagForLogic(A, 0, 0);
                   break;
            case 172:A=(A^H);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 173:A=(A^L);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 174:A=(A^memory[H*256+L]);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 175:A=(A^A);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 176:A=(A|B);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 177:A=(A|C);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 178:A=(A|D);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 179:A=(A|E);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 180:A=(A|H);
                    F=getFlagForLogic(A, 0, 0);
                    break;

            case 181:A=(A|L);
                    F=getFlagForLogic(A, 0, 0);
                   break;
            case 182:A=(A|memory[H*256+L]);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 183:A=(A|A);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 184:temp=_2sCompliment(B);
                     F=getFlagADD(A,temp);F=F^0x01;
                    break;
            case 185:temp=_2sCompliment(C);
                     F=getFlagADD(A,temp);F=F^0x01;
                    break;
            case 186:temp=_2sCompliment(D);
                     F=getFlagADD(A,temp);F=F^0x01;
                    break;
            case 187:temp=_2sCompliment(E);
                     F=getFlagADD(A,temp);F=F^0x01;
                    break;
            case 188:temp=_2sCompliment(H);
                     F=getFlagADD(A,temp);F=F^0x01;
                    break;
            case 189:temp=_2sCompliment(L);
                     F=getFlagADD(A,temp);F=F^0x01;
                    break;
            case 190:temp=_2sCompliment(memory[H*256+L]);
                     F=getFlagADD(A,temp);F=F^0x01;
                    break;
            case 191:temp=_2sCompliment(A);
                     F=getFlagADD(A,temp);F=F^0x01;
                   break;
            case 192:if((F&64)==0)
                     {int n[]=popInStack();
                        PC=n[0]*256+n[1];
                      }
                    break;
            case 193:no=popInStack();
                     B=no[0];C=no[1];
                    break;
            case 194: if ((F&64)== 0)PC = memory[PC++] + memory[PC++] * 256;
                      else {PC += 2;clockCycleCounter-=3;}
                    break;
            case 195:PC=memory[PC++]+memory[PC++]*256;
                    break;
            case 196:if((F&64)==0){
                    temp=PC+2;
                    pushInStack(temp/256, temp%256);
                    PC = memory[PC++] + memory[PC++] * 256;
                     }
                    else PC+=2;
                    break;
            case 197:pushInStack(B, C);
                    break;
            case 198:F=getFlagADD(A, memory[PC]);
                     A=A+memory[PC++];
                     if(A/256>=1)A=A%256;
                    break;
            case 199:pushInStack(PC/256, PC%256);
                    PC=beginAddress;
                    break;
            case 200:if((F&64)==64)
                     {int n[]=popInStack();
                        PC=n[0]*256+n[1];
                      }
                    break;

            case 201:{int n[]=popInStack();
                        PC=n[0]*256+n[1];   
                        }
                   break;
            case 202: if ((F&64)== 64)PC = memory[PC++] + memory[PC++] * 256;
                      else {PC += 2;clockCycleCounter-=3;}
                    break;
            case 203:
                    break;
            case 204:if((F&64)==64){
                    temp=PC+2;
                    pushInStack(temp/256, temp%256);
                    PC = memory[PC++] + memory[PC++] * 256;
                     }
                    else PC+=2;
                    break;
            case 205:temp=PC+2;
                    pushInStack(temp/256, temp%256);
                    PC = memory[PC++] + memory[PC++] * 256;
                    break;
            case 206:temp=F&1;
                     F=getFlagADD(A, memory[PC]+temp);
                     A=A+memory[PC++]+temp;
                     if(A/256>=1)A=A%256;
                    break;
            case 207:pushInStack(PC/256, PC%256);
                    PC=beginAddress+8;
                    break;
            case 208:if((F&1)==0)
                     {int n[]=popInStack();
                        PC=n[0]*256+n[1];
                      }
                    break;
            case 209:no=popInStack();
                     D=no[0];E=no[1];
                    break;
            case 210:
                    if ((F&1)== 0)PC = memory[PC++] + memory[PC++] * 256;
                    else {PC += 2;clockCycleCounter-=3;}
                    break;
            case 211:port[memory[PC++]]=A;
                   break;
            case 212:if((F&1)==0){
                    temp=PC+2;
                    pushInStack(temp/256, temp%256);
                    PC = memory[PC++] + memory[PC++] * 256;
                     }
                    else PC+=2;
                    break;
            case 213:pushInStack(D, E);
                    break;
            case 214:temp = memory[PC++];
                     temp=_2sCompliment(temp); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 215:pushInStack(PC/256, PC%256);
                    PC=beginAddress+16;
                    break;
            case 216:if((F&1)==1)
                     {int n[]=popInStack();
                        PC=n[0]*256+n[1];
                      }
                    break;
            case 217:
                    break;
            case 218:
                    if ((F&1)== 1)PC = memory[PC++] + memory[PC++] * 256;
                    else {PC += 2;clockCycleCounter-=3;}
                    break;
            case 219:A=port[memory[PC++]];
                    break;
            case 220:if((F&1)==1){
                    temp=PC+2;
                    pushInStack(temp/256, temp%256);
                    PC = memory[PC++] + memory[PC++] * 256;
                     }
                    else PC+=2;
                    break;
            case 221:
                   break;
            case 222:temp = memory[PC++]+(F&0x01);
                     temp=_2sCompliment(temp); 
                     F=getFlagADD(A,temp);F=F^0x01;
                     A=(A+temp)&0xff;
                    break;
            case 223:pushInStack(PC/256, PC%256);
                    PC=beginAddress+24;
                    break;
            case 224:if((F&4)==0)
                     {int n[]=popInStack();
                        PC=n[0]*256+n[1];
                      }
                    break;
            case 225:no=popInStack();
                     H=no[0];L=no[1];
                    break;
            case 226:
                    if ((F&4)== 0)PC = memory[PC++] + memory[PC++] * 256;
                    else {PC += 2;clockCycleCounter-=3;}
                    break;
            case 227:{
                      int temp1=H,temp2=L;
                      H=(memory[SP+1]&0xff);L=(memory[SP]&0x00ff);
                      memory[SP+1]=temp1; memory[SP]=temp2;
                     }
                    break;
            case 228:if((F&4)==0){
                    temp=PC+2;
                    pushInStack(temp/256, temp%256);
                    PC = memory[PC++] + memory[PC++] * 256;
                     }
                    else PC+=2;
                    break;
            case 229:pushInStack(H, L);
                    break;
            case 230:A=(A&memory[PC++]);
                    F=getFlagForLogic(A, 1, 0);
                    break;
            case 231:pushInStack(PC/256, PC%256);
                   PC=beginAddress+32;
                   break;
            case 232:if((F&4)==4)
                     {int n[]=popInStack();
                        PC=n[0]*256+n[1];
                      }
                    break;
            case 233:PC=H*256+L;
                    break;
            case 234:
                    if ((F&4)== 4)PC = memory[PC++] + memory[PC++] * 256;
                    else {PC += 2;clockCycleCounter-=3;}
                    break;
            case 235:temp=D;D=H;H=temp;
                     temp=E;E=L;L=temp;
                    break;
            case 236:if((F&4)==4){
                    temp=PC+2;
                    pushInStack(temp/256, temp%256);
                    PC = memory[PC++] + memory[PC++] * 256;
                     }
                    else PC+=2;
                    break;
            case 237:
                    break;
            case 238:A=(A^memory[PC++]);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 239:pushInStack(PC/256, PC%256);
                    PC=beginAddress+40;
                    break;
            case 240:if((F&128)==0)
                     {int n[]=popInStack();
                        PC=n[0]*256+n[1];
                      }
                    break;
            case 241:no=popInStack();
                     A=no[0];F=no[1];
                    break;
            case 242:
                    if ((F&128)== 0)PC = memory[PC++] + memory[PC++] * 256;
                    else {PC += 2;clockCycleCounter-=3;}
                    break;
            case 243:IE=0;
                    break;
            case 244:if((F&128)==0){
                    temp=PC+2;
                    pushInStack(temp/256, temp%256);
                    PC = memory[PC++] + memory[PC++] * 256;
                     }
                    else PC+=2;
                    break;
            case 245:pushInStack(A, F);
                    break;
            case 246:A=(A|memory[PC++]);
                    F=getFlagForLogic(A, 0, 0);
                    break;
            case 247:pushInStack(PC/256, PC%256);
                    PC=beginAddress+48;
                    break;
            case 248:if((F&128)==128)
                     {int n[]=popInStack();
                        PC=n[0]*256+n[1];
                      }
                    break;
            case 249:SP=H*256+L;
                    break;
            case 250:
                    if ((F&128)== 128)PC = memory[PC++] + memory[PC++] * 256;
                    else {PC += 2;clockCycleCounter-=3;}
                    break;
            case 251:IE=1;
                   break;
            case 252:if((F&128)==128){
                    temp=PC+2;
                    pushInStack(temp/256, temp%256);
                    PC = memory[PC++] + memory[PC++] * 256;
                     }
                    else PC+=2;
                    break;
            case 253:
                    break;
            case 254:temp=_2sCompliment(memory[PC++]);
                     F=getFlagADD(A,temp);F=F^0x01;
                    break;
            case 255:pushInStack(PC/256, PC%256);
                    PC=beginAddress+56;
                    break;

        }
        
        clockCycleCounter=clockCycleCounter+engine.I[index][2];
        instructionCounter++;

        if(stopAddress<PC||beginAddress>PC){
                        o.jButtonStop.doClick();
                        o.jLabelErrorHang.setText("You have exceeded the memory range");
                        o.jLabelErrorHang.setVisible(true);
                        PC=beginAddress;
       }
                interruptProcess();

    }

    public void pushInStack(int b,int c)
    {
        if(SP==beginAddress||SP==0)SP=stopAddress+1;
        memory[--SP]=b;
        memory[--SP]=c;
    }

    public int[] popInStack()
    {
        int[] no=new int[2];
        if(SP==stopAddress)SP=0;
        no[1]=memory[SP++];
        no[0]=memory[SP++];
        if(SP-1==stopAddress)SP=beginAddress;
        return no;

    }

    public void interruptProcess(){
        if(_RESETIN==0)IE=0;
        if(IE==1&&TRAP==1){IE=0;_INTA=0;PC=0x0024;}
        if(IE==1&&R75==1&&(RR75==0||_RESETIN==0)&&!(M75==1&&MSE==1)){IE=0;_INTA=0;PC=0x003C;}
        if(IE==1&&R65==1&&(!(M65==1&&MSE==1))){IE=0;_INTA=0;PC=0x0034;}
        if(IE==1&&R55==1&&!(M55==1&&MSE==1)){IE=0;_INTA=0;PC=0x002C;}        
        if(IE==1&&INTR==1){IE=0;_INTA=0;PC=0x0008;}
    }
    
   public int getFlagADD(int b,int c)
    {
        int S=0,Z=0,AC=0,P=0,CY=0,t=0;
        t = b + c;
        AC=((b&0xf)+(c&0xf))>0x0f?1:0;
        Z = (t & 0xff) == 0x00 ? 1 : 0;
        S = (t & 0x80) == 0x80 ? 1 : 0;
        CY= (t & 0x100)== 0x100 ? 1 : 0;
        P=getParity(t&0xff);
        return S<<7 | Z<<6 | AC<<4 | P<<2 | CY;
    }
   
      public int getFlagINR(int b,int CY)
    {
        int S=0,Z=0,AC=0,P=0,t=0;
        t = b + 1;
        AC=((b&0xf)+1)>0x0f?1:0;
        Z = (t & 0xff) == 0x00 ? 1 : 0;
        S = (t & 0x80) == 0x80 ? 1 : 0;
        P=getParity(t&0xff);
        return S<<7 | Z<<6 | AC<<4 | P<<2 | CY;

    }
   

    public int getFlagForLogic(int b,int ac,int c)
    {
        int S=0,Z=0,d2=0,AC=0,d1=0,P=0,d0=0,CY=0;
        if(b>127)S=1;
        if(b==c)Z=1;
        AC=ac;CY=c;
        P=(b/128)^(b/64)%2^(b/32)%2^(b/16)%2^(b/8)%2^(b/4)%2^(b/2)%2^(b%2)^1;
        return S*128+Z*64+d2*32+AC*16+d1*8+P*4+d0*2+CY;

    }
    
    int getParity(int num){
        int parity = num & 0xff;
        parity ^= ( parity >> 4 );
        parity ^= parity >> 2;
        parity ^= parity >> 1;
        return ( parity & 1 ) == 0?1:0;
    }
    
    int _2sCompliment(int num){
        return (((num&0xFF)^0xFF)+1)&0xFF;
    }
    
    public static void main(String[] args) {
        Assembler a=new Assembler();
        Matrix matrix = new Matrix(a);
        matrix.PC=90;
        matrix.functionRun(195);
        System.out.println(matrix.engine.Dec2Bin(240));
        System.out.println(Integer.toBinaryString(matrix.getFlagADD(18, 18)));
        System.out.println((36 & 0x80) != 0x80 ? 1 : 0);
        System.out.println(matrix.getParity(0xff));
        System.out.println("0x"+Integer.toHexString(0xff<<4));
        System.out.println("0x"+Integer.toHexString(0xff>>4));
        System.out.println("0x"+Integer.toHexString(0xff>>>4));
        System.out.println("0x"+Integer.toHexString(1<<7|1<<2));
        System.out.println("0x"+Integer.toHexString(0x12<<8|0x34));
        a.dispose();
        
}

}
