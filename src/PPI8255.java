
public class PPI8255 implements Runnable{

    public int PortAin,PortBin,PortCin,CRin,PortAout,PortBout,PortCout,CRout;
    public int PortAaddress,PortBaddress,PortCaddress,CRaddress;

    AssemblerEngine engine=new AssemblerEngine();
    Assembler o;
    public PPI8255()
    {

    }

    public PPI8255(Assembler assembler)
    {
        o=assembler;
       // engine8255();
    }
    public void setAddress()
    {
        PortAaddress=engine.Hex2Dec(o.jTable8255.getValueAt(2, 1).toString());
        PortBaddress=engine.Hex2Dec(o.jTable8255.getValueAt(2, 1).toString());
        PortCaddress=engine.Hex2Dec(o.jTable8255.getValueAt(2, 1).toString());
        CRaddress=engine.Hex2Dec(o.jTable8255.getValueAt(2, 1).toString());
    }

    public void process()
    {

    }

    public void set() {
        /*String port[] = {engine.Dec2Bin(PortA), engine.Dec2Bin(PortB), engine.Dec2Bin(PortC), engine.Dec2Bin(CR)};
        o.jTable8255.setValueAt(PortA, 0, 2);
        o.jTable8255.setValueAt(PortB, 1, 2);
        o.jTable8255.setValueAt(PortC, 2, 2);
        o.jTable8255.setValueAt(CR, 3, 2);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                o.jTable8255.setValueAt(port[j].charAt(i), j, 3 + i);
            }

        }*/


    }

 public void get() {
        PortAin=engine.Hex2Dec(o.jTable8255.getValueAt( 0, 2).toString());
        /*PortB=engine.Hex2Dec(o.jTable8255.getValueAt( 1, 2).toString());
        PortC=engine.Hex2Dec(o.jTable8255.getValueAt( 2, 2).toString());
        CR=engine.Hex2Dec(o.jTable8255.getValueAt( 3, 2).toString());
    */}

    @Override
    public void run() {
    }

}
