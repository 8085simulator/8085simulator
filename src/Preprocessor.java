/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jubin
 */
public class Preprocessor {
    
    Assembler obj;
    String s="";
    String[] code=new String[10];
    int actualAddr=0,virtualAdd=0;
    
    public Preprocessor(){
        init();
    }
    
    public void process(Assembler o,String macro,int index){
        obj = o;
        s = macro;
        actualAddr = index;
        try{
        parser(macro);}
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void init(){
        code[0]="ORG ";
        code[1]="BEGIN ";
        code[2]=" EQU ";
        code[3]=" DW ";
        code[4]=" DB ";
        code[5]=" DS ";
        code[6]="END";
        code[7]="";
        code[8]="";
        code[9]="";
    }
    
    public void parser(String s){
        virtualAdd++;
        //System.out.println(s);
        String temp="";
        if(s.contains("ORG"))
        {
            if(s.indexOf("ORG")>-1){
                temp=s.substring(s.indexOf("ORG")+3,s.lastIndexOf(":")).trim().toUpperCase();
                temp=temp.replaceAll(" ", "");
                if(temp.equalsIgnoreCase("RST0")) temp="0000";
                else if(temp.equalsIgnoreCase("RST1")) temp="0008";
                else if(temp.equalsIgnoreCase("RST2")) temp="0010";
                else if(temp.equalsIgnoreCase("RST3")) temp="0018";
                else if(temp.equalsIgnoreCase("RST4")) temp="0020";
                else if(temp.equalsIgnoreCase("RST5")) temp="0028";
                else if(temp.equalsIgnoreCase("RST6")) temp="0030";
                else if(temp.equalsIgnoreCase("RST7")) temp="0038";
                else if(temp.equalsIgnoreCase("RST5.5")) temp="002C";
                else if(temp.equalsIgnoreCase("RST6.5")) temp="0034";
                else if(temp.equalsIgnoreCase("RST7.5")) temp="003C";
                obj.memShift=obj.engine.convertToNum(temp);
             }
        }
        else if (s.contains("BEGIN"))
        {
            obj.jTextFieldBeginFrom.setText(obj.engine.Dec2Hex(obj.engine.convertToNum(s.substring(s.indexOf("ORG")+3,s.lastIndexOf(":")).trim())));
        }
        else if (s.contains("EQU"))
        {
            if(s.indexOf("EQU")>-1){
                obj.matrix.preLabel[virtualAdd][0]=s.substring(0, s.indexOf("EQU")).trim();
                obj.matrix.preLabel[virtualAdd][1]=s.substring(s.indexOf("EQU")+3, s.lastIndexOf(":")).trim();
            }
        }
        else if (s.contains("DW"))
        {
            if(s.indexOf(':')>-1)
            {
                obj.matrix.preLabel[virtualAdd][0]=(s.substring(0,s.indexOf(':')).trim());
                obj.matrix.preLabel[virtualAdd][1]=(obj.engine.Dec2Hex(actualAddr));
            }
            obj.matrix.memory[actualAddr++]=(obj.engine.convertToNum(s.substring(s.indexOf("DW")+2, s.lastIndexOf(':')).trim())&0x00ff);
            obj.matrix.memory[actualAddr++]=(obj.engine.convertToNum(s.substring(s.indexOf("DW")+2, s.lastIndexOf(':')).trim())&0xff00)>>8;
        }
        else if (s.contains("DB"))
        {
            if(s.indexOf(':')>-1)
            {
                obj.matrix.preLabel[virtualAdd][0]=(s.substring(0,s.indexOf(':')).trim());
                obj.matrix.preLabel[virtualAdd][1]=(obj.engine.Dec2Hex(actualAddr));
            }
            if(s.indexOf(',')>-1)
                obj.matrix.memory[actualAddr++]=(obj.engine.convertToNum(s.substring(s.indexOf("DB")+2, s.indexOf(',')).trim()));
            else 
                obj.matrix.memory[actualAddr++]=(obj.engine.convertToNum(s.substring(s.indexOf("DB")+2, s.lastIndexOf(':')).trim()));
            while(s.indexOf(",")>-1 && s.indexOf(",")!=s.lastIndexOf(",")){
                obj.matrix.memory[actualAddr++]=(obj.engine.convertToNum(s.substring(s.indexOf(",")+1, s.indexOf(",", s.indexOf(",")+1)).trim()));
                s=s.substring(s.indexOf(",")+1);
            }
            if(s.indexOf(",")>-1)
                       obj.matrix.memory[actualAddr++]=(obj.engine.convertToNum(s.substring(s.indexOf(",")+1, s.lastIndexOf(":")).trim()));
        }
        else if (s.contains("DS"))
        {
            if(s.indexOf(':')>-1)
            {
                obj.matrix.preLabel[virtualAdd][0]=(s.substring(0,s.indexOf(':')).trim());
                obj.matrix.preLabel[virtualAdd][1]=(obj.engine.Dec2Hex(actualAddr));
            }    
            obj.memShift = actualAddr+obj.engine.convertToNum(s.substring(s.indexOf("DS")+2, s.lastIndexOf(":")).trim());
        }
        else if (s.contains("END"))
        {
            obj.matrix.memory[actualAddr++]=obj.stopAtIndex;
        }
        
    }
    
    
public static void main(String[] args) {
        Preprocessor p = new Preprocessor();
        //String s="ORG 2000H\nPORT1 EQU 01H\nSTACK EQU INBUF+1\nDATA: DB A2H,9FH\nDW 2050H\nOUTBUF: DS 4";
        String s="DATA: DB 10D,11D,23D,45D,65D";
        System.out.println(s.indexOf(","));
        System.out.println(s.lastIndexOf(","));
        //p.parser(s);
        System.out.println(((0xff00)>>8));
    }
            
    
}
