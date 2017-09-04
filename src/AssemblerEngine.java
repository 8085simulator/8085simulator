import java.util.regex.*;

public class AssemblerEngine {

    public  String S[] = new String[256];
    public int I[][] = new int[256][3];//bytes,M-cycles,T-states
    Matrix m;

    public AssemblerEngine(Matrix o) {

        initCycles();
        initHexcode();
        m = o;
    }

    public AssemblerEngine() {

        initCycles();
        initHexcode();

    }

    public void initHexcode() {
        S[0] = "NOP";
        S[1] = "LXI B,XXXX";
        S[2] = "STAX B";
        S[3] = "INX B";
        S[4] = "INR B";
        S[5] = "DCR B";
        S[6] = "MVI B,XX";
        S[7] = "RLC";
        S[8] = "";
        S[9] = "DAD B";
        S[10] = "LDAX B";
        S[11] = "DCX B";
        S[12] = "INR C";
        S[13] = "DCR C";
        S[14] = "MVI C,XX";
        S[15] = "RRC";
        S[16] = "";
        S[17] = "LXI D,XXXX";
        S[18] = "STAX D";
        S[19] = "INX D";
        S[20] = "INR D";
        S[21] = "DCR D";
        S[22] = "MVI D,XX";
        S[23] = "RAL";
        S[24] = "";
        S[25] = "DAD D";
        S[26] = "LDAX D";
        S[27] = "DCX D";
        S[28] = "INR E";
        S[29] = "DCR E";
        S[30] = "MVI E,XX";
        S[31] = "RAR";
        S[32] = "RIM";
        S[33] = "LXI H,XXXX";
        S[34] = "SHLD XXXX";
        S[35] = "INX H";
        S[36] = "INR H";
        S[37] = "DCR H";
        S[38] = "MVI H,XX";
        S[39] = "DAA";
        S[40] = "";
        S[41] = "DAD H";
        S[42] = "LHLD XXXX";
        S[43] = "DCX H";
        S[44] = "INR L";
        S[45] = "DCR L";
        S[46] = "MVI L,XX";
        S[47] = "CMA";
        S[48] = "SIM";
        S[49] = "LXI SP,XXXX";
        S[50] = "STA XXXX";
        S[51] = "INX SP";
        S[52] = "INR M";
        S[53] = "DCR M";
        S[54] = "MVI M,XX";
        S[55] = "STC";
        S[56] = "";
        S[57] = "DAD SP";
        S[58] = "LDA XXXX";
        S[59] = "DCX SP";
        S[60] = "INR A";
        S[61] = "DCR A";
        S[62] = "MVI A,XX";
        S[63] = "CMC";
        S[64] = "MOV B,B";
        S[65] = "MOV B,C";
        S[66] = "MOV B,D";
        S[67] = "MOV B,E";
        S[68] = "MOV B,H";
        S[69] = "MOV B,L";
        S[70] = "MOV B,M";
        S[71] = "MOV B,A";
        S[72] = "MOV C,B";
        S[73] = "MOV C,C";
        S[74] = "MOV C,D";
        S[75] = "MOV C,E";
        S[76] = "MOV C,H";
        S[77] = "MOV C,L";
        S[78] = "MOV C,M";
        S[79] = "MOV C,A";
        S[80] = "MOV D,B";
        S[81] = "MOV D,C";
        S[82] = "MOV D,D";
        S[83] = "MOV D,E";
        S[84] = "MOV D,H";
        S[85] = "MOV D,L";
        S[86] = "MOV D,M";
        S[87] = "MOV D,A";
        S[88] = "MOV E,B";
        S[89] = "MOV E,C";
        S[90] = "MOV E,D";
        S[91] = "MOV E,E";
        S[92] = "MOV E,H";
        S[93] = "MOV E,L";
        S[94] = "MOV E,M";
        S[95] = "MOV E,A";
        S[96] = "MOV H,B";
        S[97] = "MOV H,C";
        S[98] = "MOV H,D";
        S[99] = "MOV H,E";
        S[100] = "MOV H,H";
        S[101] = "MOV H,L";
        S[102] = "MOV H,M";
        S[103] = "MOV H,A";
        S[104] = "MOV L,B";
        S[105] = "MOV L,C";
        S[106] = "MOV L,D";
        S[107] = "MOV L,E";
        S[108] = "MOV L,H";
        S[109] = "MOV L,L";
        S[110] = "MOV L,M";
        S[111] = "MOV L,A";
        S[112] = "MOV M,B";
        S[113] = "MOV M,C";
        S[114] = "MOV M,D";
        S[115] = "MOV M,E";
        S[116] = "MOV M,H";
        S[117] = "MOV M,L";
        S[118] = "HLT";
        S[119] = "MOV M,A";
        S[120] = "MOV A,B";
        S[121] = "MOV A,C";
        S[122] = "MOV A,D";
        S[123] = "MOV A,E";
        S[124] = "MOV A,H";
        S[125] = "MOV A,L";
        S[126] = "MOV A,M";
        S[127] = "MOV A,A";
        S[128] = "ADD B";
        S[129] = "ADD C";
        S[130] = "ADD D";
        S[131] = "ADD E";
        S[132] = "ADD H";
        S[133] = "ADD L";
        S[134] = "ADD M";
        S[135] = "ADD A";
        S[136] = "ADC B";
        S[137] = "ADC C";
        S[138] = "ADC D";
        S[139] = "ADC E";
        S[140] = "ADC H";
        S[141] = "ADC L";
        S[142] = "ADC M";
        S[143] = "ADC A";
        S[144] = "SUB B";
        S[145] = "SUB C";
        S[146] = "SUB D";
        S[147] = "SUB E";
        S[148] = "SUB H";
        S[149] = "SUB L";
        S[150] = "SUB M";
        S[151] = "SUB A";
        S[152] = "SBB B";
        S[153] = "SBB C";
        S[154] = "SBB D";
        S[155] = "SBB E";
        S[156] = "SBB H";
        S[157] = "SBB L";
        S[158] = "SBB M";
        S[159] = "SBB A";
        S[160] = "ANA B";
        S[161] = "ANA C";
        S[162] = "ANA D";
        S[163] = "ANA E";
        S[164] = "ANA H";
        S[165] = "ANA L";
        S[166] = "ANA M";
        S[167] = "ANA A";
        S[168] = "XRA B";
        S[169] = "XRA C";
        S[170] = "XRA D";
        S[171] = "XRA E";
        S[172] = "XRA H";
        S[173] = "XRA L";
        S[174] = "XRA M";
        S[175] = "XRA A";
        S[176] = "ORA B";
        S[177] = "ORA C";
        S[178] = "ORA D";
        S[179] = "ORA E";
        S[180] = "ORA H";
        S[181] = "ORA L";
        S[182] = "ORA M";
        S[183] = "ORA A";
        S[184] = "CMP B";
        S[185] = "CMP C";
        S[186] = "CMP D";
        S[187] = "CMP E";
        S[188] = "CMP H";
        S[189] = "CMP L";
        S[190] = "CMP M";
        S[191] = "CMP A";
        S[192] = "RNZ";
        S[193] = "POP B";
        S[194] = "JNZ XXXX";
        S[195] = "JMP XXXX";
        S[196] = "CNZ XXXX";
        S[197] = "PUSH B";
        S[198] = "ADI XX";
        S[199] = "RST 0";
        S[200] = "RZ";
        S[201] = "RET";
        S[202] = "JZ XXXX";
        S[203] = "";
        S[204] = "CZ XXXX";
        S[205] = "CALL XXXX";
        S[206] = "ACI XX";
        S[207] = "RST 1";
        S[208] = "RNC";
        S[209] = "POP D";
        S[210] = "JNC XXXX";
        S[211] = "OUT XX";
        S[212] = "CNC XXXX";
        S[213] = "PUSH D";
        S[214] = "SUI XX";
        S[215] = "RST 2";
        S[216] = "RC";
        S[217] = "";
        S[218] = "JC XXXX";
        S[219] = "IN XX";
        S[220] = "CC XXXX";
        S[221] = "";
        S[222] = "SBI XX";
        S[223] = "RST 3";
        S[224] = "RPO";
        S[225] = "POP H";
        S[226] = "JPO XXXX";
        S[227] = "XTHL";
        S[228] = "CPO XXXX";
        S[229] = "PUSH H";
        S[230] = "ANI XX";
        S[231] = "RST 4";
        S[232] = "RPE";
        S[233] = "PCHL";
        S[234] = "JPE XXXX";
        S[235] = "XCHG";
        S[236] = "CPE XXXX";
        S[237] = "";
        S[238] = "XRI XX";
        S[239] = "RST 5";
        S[240] = "RP";
        S[241] = "POP PSW";
        S[242] = "JP XXXX";
        S[243] = "DI";
        S[244] = "CP XXXX";
        S[245] = "PUSH PSW";
        S[246] = "ORI XX";
        S[247] = "RST 6";
        S[248] = "RM";
        S[249] = "SPHL";
        S[250] = "JM XXXX";
        S[251] = "EI";
        S[252] = "CM XXXX";
        S[253] = "";
        S[254] = "CPI XX";
        S[255] = "RST 7";
    }

    public void initCycles() {
        I[0][0] = 1;
        I[0][1] = 1;
        I[0][2] = 4;
        I[1][0] = 3;
        I[1][1] = 3;
        I[1][2] = 10;
        I[2][0] = 1;
        I[2][1] = 2;
        I[2][2] = 7;
        I[3][0] = 1;
        I[3][1] = 1;
        I[3][2] = 6;
        I[4][0] = 1;
        I[4][1] = 1;
        I[4][2] = 4;
        I[5][0] = 1;
        I[5][1] = 1;
        I[5][2] = 4;
        I[6][0] = 2;
        I[6][1] = 2;
        I[6][2] = 7;
        I[7][0] = 1;
        I[7][1] = 1;
        I[7][2] = 4;
        I[8][0] = 0;
        I[8][1] = 0;
        I[8][2] = 0;
        I[9][0] = 1;
        I[9][1] = 3;
        I[9][2] = 10;

        I[10][0] = 1;
        I[10][1] = 2;
        I[10][2] = 7;
        I[11][0] = 1;
        I[11][1] = 1;
        I[11][2] = 6;
        I[12][0] = 1;
        I[12][1] = 1;
        I[12][2] = 4;
        I[13][0] = 1;
        I[13][1] = 1;
        I[13][2] = 4;
        I[14][0] = 2;
        I[14][1] = 2;
        I[14][2] = 7;
        I[15][0] = 1;
        I[15][1] = 1;
        I[15][2] = 4;
        I[16][0] = 0;
        I[16][1] = 0;
        I[16][2] = 0;
        I[17][0] = 3;
        I[17][1] = 3;
        I[17][2] = 10;
        I[18][0] = 1;
        I[18][1] = 2;
        I[18][2] = 7;
        I[19][0] = 1;
        I[19][1] = 1;
        I[19][2] = 6;

        I[20][0] = 1;
        I[20][1] = 1;
        I[20][2] = 4;
        I[21][0] = 1;
        I[21][1] = 1;
        I[21][2] = 4;
        I[22][0] = 2;
        I[22][1] = 2;
        I[22][2] = 7;
        I[23][0] = 1;
        I[23][1] = 1;
        I[23][2] = 4;
        I[24][0] = 0;
        I[24][1] = 0;
        I[24][2] = 0;
        I[25][0] = 1;
        I[25][1] = 3;
        I[25][2] = 10;
        I[26][0] = 1;
        I[26][1] = 2;
        I[26][2] = 7;
        I[27][0] = 1;
        I[27][1] = 1;
        I[27][2] = 6;
        I[28][0] = 1;
        I[28][1] = 1;
        I[28][2] = 4;
        I[29][0] = 1;
        I[29][1] = 1;
        I[29][2] = 4;

        I[30][0] = 2;
        I[30][1] = 2;
        I[30][2] = 7;
        I[31][0] = 1;
        I[31][1] = 1;
        I[31][2] = 4;
        I[32][0] = 1;
        I[32][1] = 1;
        I[32][2] = 4;
        I[33][0] = 3;
        I[33][1] = 3;
        I[33][2] = 10;
        I[34][0] = 3;
        I[34][1] = 5;
        I[34][2] = 16;
        I[35][0] = 1;
        I[35][1] = 1;
        I[35][2] = 6;
        I[36][0] = 1;
        I[36][1] = 1;
        I[36][2] = 4;
        I[37][0] = 1;
        I[37][1] = 1;
        I[37][2] = 4;
        I[38][0] = 2;
        I[38][1] = 2;
        I[38][2] = 7;
        I[39][0] = 1;
        I[39][1] = 1;
        I[39][2] = 4;

        I[40][0] = 0;
        I[40][1] = 0;
        I[40][2] = 0;
        I[41][0] = 1;
        I[41][1] = 3;
        I[41][2] = 10;
        I[42][0] = 3;
        I[42][1] = 5;
        I[42][2] = 16;
        I[43][0] = 1;
        I[43][1] = 1;
        I[43][2] = 6;
        I[44][0] = 1;
        I[44][1] = 1;
        I[44][2] = 4;
        I[45][0] = 1;
        I[45][1] = 1;
        I[45][2] = 4;
        I[46][0] = 2;
        I[46][1] = 2;
        I[46][2] = 7;
        I[47][0] = 1;
        I[47][1] = 1;
        I[47][2] = 4;
        I[48][0] = 1;
        I[48][1] = 1;
        I[48][2] = 4;
        I[49][0] = 3;
        I[49][1] = 3;
        I[49][2] = 10;

        I[50][0] = 3;
        I[50][1] = 4;
        I[50][2] = 13;
        I[51][0] = 1;
        I[51][1] = 1;
        I[51][2] = 6;
        I[52][0] = 1;
        I[52][1] = 3;
        I[52][2] = 10;
        I[53][0] = 1;
        I[53][1] = 3;
        I[53][2] = 10;
        I[54][0] = 2;
        I[54][1] = 3;
        I[54][2] = 10;
        I[55][0] = 1;
        I[55][1] = 1;
        I[55][2] = 4;
        I[56][0] = 0;
        I[56][1] = 0;
        I[56][2] = 0;
        I[57][0] = 1;
        I[57][1] = 3;
        I[57][2] = 10;
        I[58][0] = 3;
        I[58][1] = 4;
        I[58][2] = 13;
        I[59][0] = 1;
        I[59][1] = 1;
        I[59][2] = 6;

        I[60][0] = 1;
        I[60][1] = 1;
        I[60][2] = 4;
        I[61][0] = 1;
        I[61][1] = 1;
        I[61][2] = 4;
        I[62][0] = 2;
        I[62][1] = 2;
        I[62][2] = 7;
        I[63][0] = 1;
        I[63][1] = 1;
        I[63][2] = 4;
        I[64][0] = 1;
        I[64][1] = 1;
        I[64][2] = 4;
        I[65][0] = 1;
        I[65][1] = 1;
        I[65][2] = 4;
        I[66][0] = 1;
        I[66][1] = 1;
        I[66][2] = 4;
        I[67][0] = 1;
        I[67][1] = 1;
        I[67][2] = 4;
        I[68][0] = 1;
        I[68][1] = 1;
        I[68][2] = 4;
        I[69][0] = 1;
        I[69][1] = 1;
        I[69][2] = 4;

        I[70][0] = 1;
        I[70][1] = 2;
        I[70][2] = 7;
        I[71][0] = 1;
        I[71][1] = 1;
        I[71][2] = 4;
        I[72][0] = 1;
        I[72][1] = 1;
        I[72][2] = 4;
        I[73][0] = 1;
        I[73][1] = 1;
        I[73][2] = 4;
        I[74][0] = 1;
        I[74][1] = 1;
        I[74][2] = 4;
        I[75][0] = 1;
        I[75][1] = 1;
        I[75][2] = 4;
        I[76][0] = 1;
        I[76][1] = 1;
        I[76][2] = 4;
        I[77][0] = 1;
        I[77][1] = 1;
        I[77][2] = 4;
        I[78][0] = 1;
        I[78][1] = 2;
        I[78][2] = 7;
        I[79][0] = 1;
        I[79][1] = 1;
        I[79][2] = 4;

        I[80][0] = 1;
        I[80][1] = 1;
        I[80][2] = 4;
        I[81][0] = 1;
        I[81][1] = 1;
        I[81][2] = 4;
        I[82][0] = 1;
        I[82][1] = 1;
        I[82][2] = 4;
        I[83][0] = 1;
        I[83][1] = 1;
        I[83][2] = 4;
        I[84][0] = 1;
        I[84][1] = 1;
        I[84][2] = 4;
        I[85][0] = 1;
        I[85][1] = 1;
        I[85][2] = 4;
        I[86][0] = 1;
        I[86][1] = 2;
        I[86][2] = 7;
        I[87][0] = 1;
        I[87][1] = 1;
        I[87][2] = 4;
        I[88][0] = 1;
        I[88][1] = 1;
        I[88][2] = 4;
        I[89][0] = 1;
        I[89][1] = 1;
        I[89][2] = 4;

        I[90][0] = 1;
        I[90][1] = 1;
        I[90][2] = 4;
        I[91][0] = 1;
        I[91][1] = 1;
        I[91][2] = 4;
        I[92][0] = 1;
        I[92][1] = 1;
        I[92][2] = 4;
        I[93][0] = 1;
        I[93][1] = 1;
        I[93][2] = 4;
        I[94][0] = 1;
        I[94][1] = 2;
        I[94][2] = 7;
        I[95][0] = 1;
        I[95][1] = 1;
        I[95][2] = 4;
        I[96][0] = 1;
        I[96][1] = 1;
        I[96][2] = 4;
        I[97][0] = 1;
        I[97][1] = 1;
        I[97][2] = 4;
        I[98][0] = 1;
        I[98][1] = 1;
        I[98][2] = 4;
        I[99][0] = 1;
        I[99][1] = 1;
        I[99][2] = 4;

        I[100][0] = 1;
        I[100][1] = 1;
        I[100][2] = 4;
        I[101][0] = 1;
        I[101][1] = 1;
        I[101][2] = 4;
        I[102][0] = 1;
        I[102][1] = 2;
        I[102][2] = 7;
        I[103][0] = 1;
        I[103][1] = 1;
        I[103][2] = 4;
        I[104][0] = 1;
        I[104][1] = 1;
        I[104][2] = 4;
        I[105][0] = 1;
        I[105][1] = 1;
        I[105][2] = 4;
        I[106][0] = 1;
        I[106][1] = 1;
        I[106][2] = 4;
        I[107][0] = 1;
        I[107][1] = 1;
        I[107][2] = 4;
        I[108][0] = 1;
        I[108][1] = 1;
        I[108][2] = 4;
        I[109][0] = 1;
        I[109][1] = 1;
        I[109][2] = 4;

        I[110][0] = 1;
        I[110][1] = 2;
        I[110][2] = 7;
        I[111][0] = 1;
        I[111][1] = 1;
        I[111][2] = 4;
        I[112][0] = 1;
        I[112][1] = 2;
        I[112][2] = 7;
        I[113][0] = 1;
        I[113][1] = 2;
        I[113][2] = 7;
        I[114][0] = 1;
        I[114][1] = 2;
        I[114][2] = 7;
        I[115][0] = 1;
        I[115][1] = 2;
        I[115][2] = 7;
        I[116][0] = 1;
        I[116][1] = 2;
        I[116][2] = 7;
        I[117][0] = 1;
        I[117][1] = 2;
        I[117][2] = 7;
        I[118][0] = 1;
        I[118][1] = 2;
        I[118][2] = 5;
        I[119][0] = 1;
        I[119][1] = 2;
        I[119][2] = 7;

        I[120][0] = 1;
        I[120][1] = 1;
        I[120][2] = 4;
        I[121][0] = 1;
        I[121][1] = 1;
        I[121][2] = 4;
        I[122][0] = 1;
        I[122][1] = 1;
        I[122][2] = 4;
        I[123][0] = 1;
        I[123][1] = 1;
        I[123][2] = 4;
        I[124][0] = 1;
        I[124][1] = 1;
        I[124][2] = 4;
        I[125][0] = 1;
        I[125][1] = 1;
        I[125][2] = 4;
        I[126][0] = 1;
        I[126][1] = 2;
        I[126][2] = 7;
        I[127][0] = 1;
        I[127][1] = 1;
        I[127][2] = 4;
        I[128][0] = 1;
        I[128][1] = 1;
        I[128][2] = 4;
        I[129][0] = 1;
        I[129][1] = 1;
        I[129][2] = 4;

        I[130][0] = 1;
        I[130][1] = 1;
        I[130][2] = 4;
        I[131][0] = 1;
        I[131][1] = 1;
        I[131][2] = 4;
        I[132][0] = 1;
        I[132][1] = 1;
        I[132][2] = 4;
        I[133][0] = 1;
        I[133][1] = 1;
        I[133][2] = 4;
        I[134][0] = 1;
        I[134][1] = 2;
        I[134][2] = 7;
        I[135][0] = 1;
        I[135][1] = 1;
        I[135][2] = 4;
        I[136][0] = 1;
        I[136][1] = 1;
        I[136][2] = 4;
        I[137][0] = 1;
        I[137][1] = 1;
        I[137][2] = 4;
        I[138][0] = 1;
        I[138][1] = 1;
        I[138][2] = 4;
        I[139][0] = 1;
        I[139][1] = 1;
        I[139][2] = 4;

        I[140][0] = 1;
        I[140][1] = 1;
        I[140][2] = 4;
        I[141][0] = 1;
        I[141][1] = 1;
        I[141][2] = 4;
        I[142][0] = 1;
        I[142][1] = 2;
        I[142][2] = 7;
        I[143][0] = 1;
        I[143][1] = 1;
        I[143][2] = 4;
        I[144][0] = 1;
        I[144][1] = 1;
        I[144][2] = 4;
        I[145][0] = 1;
        I[145][1] = 1;
        I[145][2] = 4;
        I[146][0] = 1;
        I[146][1] = 1;
        I[146][2] = 4;
        I[147][0] = 1;
        I[147][1] = 1;
        I[147][2] = 4;
        I[148][0] = 1;
        I[148][1] = 1;
        I[148][2] = 4;
        I[149][0] = 1;
        I[149][1] = 1;
        I[149][2] = 4;

        I[150][0] = 1;
        I[150][1] = 2;
        I[150][2] = 7;
        I[151][0] = 1;
        I[151][1] = 1;
        I[151][2] = 4;
        I[152][0] = 1;
        I[152][1] = 1;
        I[152][2] = 4;
        I[153][0] = 1;
        I[153][1] = 1;
        I[153][2] = 4;
        I[154][0] = 1;
        I[154][1] = 1;
        I[154][2] = 4;
        I[155][0] = 1;
        I[155][1] = 1;
        I[155][2] = 4;
        I[156][0] = 1;
        I[156][1] = 1;
        I[156][2] = 4;
        I[157][0] = 1;
        I[157][1] = 1;
        I[157][2] = 4;
        I[158][0] = 1;
        I[158][1] = 2;
        I[158][2] = 7;
        I[159][0] = 1;
        I[159][1] = 1;
        I[159][2] = 4;

        I[160][0] = 1;
        I[160][1] = 1;
        I[160][2] = 4;
        I[161][0] = 1;
        I[161][1] = 1;
        I[161][2] = 4;
        I[162][0] = 1;
        I[162][1] = 1;
        I[162][2] = 4;
        I[163][0] = 1;
        I[163][1] = 1;
        I[163][2] = 4;
        I[164][0] = 1;
        I[164][1] = 1;
        I[164][2] = 4;
        I[165][0] = 1;
        I[165][1] = 1;
        I[165][2] = 4;
        I[166][0] = 1;
        I[166][1] = 2;
        I[166][2] = 7;
        I[167][0] = 1;
        I[167][1] = 1;
        I[167][2] = 4;
        I[168][0] = 1;
        I[168][1] = 1;
        I[168][2] = 4;
        I[169][0] = 1;
        I[169][1] = 1;
        I[169][2] = 4;

        I[170][0] = 1;
        I[170][1] = 1;
        I[170][2] = 4;
        I[171][0] = 1;
        I[171][1] = 1;
        I[171][2] = 4;
        I[172][0] = 1;
        I[172][1] = 1;
        I[172][2] = 4;
        I[173][0] = 1;
        I[173][1] = 1;
        I[173][2] = 4;
        I[174][0] = 1;
        I[174][1] = 2;
        I[174][2] = 7;
        I[175][0] = 1;
        I[175][1] = 1;
        I[175][2] = 4;
        I[176][0] = 1;
        I[176][1] = 1;
        I[176][2] = 4;
        I[177][0] = 1;
        I[177][1] = 1;
        I[177][2] = 4;
        I[178][0] = 1;
        I[178][1] = 1;
        I[178][2] = 4;
        I[179][0] = 1;
        I[179][1] = 1;
        I[179][2] = 4;

        I[180][0] = 1;
        I[180][1] = 1;
        I[180][2] = 4;
        I[181][0] = 1;
        I[181][1] = 1;
        I[181][2] = 4;
        I[182][0] = 1;
        I[182][1] = 2;
        I[182][2] = 7;
        I[183][0] = 1;
        I[183][1] = 1;
        I[183][2] = 4;
        I[184][0] = 1;
        I[184][1] = 1;
        I[184][2] = 4;
        I[185][0] = 1;
        I[185][1] = 1;
        I[185][2] = 4;
        I[186][0] = 1;
        I[186][1] = 1;
        I[186][2] = 4;
        I[187][0] = 1;
        I[187][1] = 1;
        I[187][2] = 4;
        I[188][0] = 1;
        I[188][1] = 1;
        I[188][2] = 4;
        I[189][0] = 1;
        I[189][1] = 1;
        I[189][2] = 4;

        I[190][0] = 1;
        I[190][1] = 2;
        I[190][2] = 7;
        I[191][0] = 1;
        I[191][1] = 1;
        I[191][2] = 4;
        I[192][0] = 1;
        I[192][1] = 3;
        I[192][2] = 10;
        I[193][0] = 1;
        I[193][1] = 3;
        I[193][2] = 10;
        I[194][0] = 3;
        I[194][1] = 3;
        I[194][2] = 10;
        I[195][0] = 3;
        I[195][1] = 3;
        I[195][2] = 10;
        I[196][0] = 3;
        I[196][1] = 5;
        I[196][2] = 18;
        I[197][0] = 1;
        I[197][1] = 3;
        I[197][2] = 12;
        I[198][0] = 2;
        I[198][1] = 2;
        I[198][2] = 7;
        I[199][0] = 1;
        I[199][1] = 3;
        I[199][2] = 12;

        I[200][0] = 1;
        I[200][1] = 3;
        I[200][2] = 10;
        I[201][0] = 1;
        I[201][1] = 3;
        I[201][2] = 10;
        I[202][0] = 3;
        I[202][1] = 3;
        I[202][2] = 10;
        I[203][0] = 0;
        I[203][1] = 0;
        I[203][2] = 0;
        I[204][0] = 3;
        I[204][1] = 5;
        I[204][2] = 18;
        I[205][0] = 3;
        I[205][1] = 5;
        I[205][2] = 18;
        I[206][0] = 2;
        I[206][1] = 2;
        I[206][2] = 7;
        I[207][0] = 1;
        I[207][1] = 3;
        I[207][2] = 12;
        I[208][0] = 1;
        I[208][1] = 3;
        I[208][2] = 10;
        I[209][0] = 1;
        I[209][1] = 3;
        I[209][2] = 10;

        I[210][0] = 3;
        I[210][1] = 3;
        I[210][2] = 10;
        I[211][0] = 2;
        I[211][1] = 3;
        I[211][2] = 10;
        I[212][0] = 3;
        I[212][1] = 5;
        I[212][2] = 18;
        I[213][0] = 1;
        I[213][1] = 3;
        I[213][2] = 12;
        I[214][0] = 2;
        I[214][1] = 2;
        I[214][2] = 7;
        I[215][0] = 1;
        I[215][1] = 3;
        I[215][2] = 12;
        I[216][0] = 1;
        I[216][1] = 3;
        I[216][2] = 10;
        I[217][0] = 0;
        I[217][1] = 0;
        I[217][2] = 0;
        I[218][0] = 3;
        I[218][1] = 3;
        I[218][2] = 10;
        I[219][0] = 2;
        I[219][1] = 3;
        I[219][2] = 10;

        I[220][0] = 3;
        I[220][1] = 5;
        I[220][2] = 18;
        I[221][0] = 0;
        I[221][1] = 0;
        I[221][2] = 0;
        I[222][0] = 2;
        I[222][1] = 2;
        I[222][2] = 7;
        I[223][0] = 1;
        I[223][1] = 3;
        I[223][2] = 12;
        I[224][0] = 1;
        I[224][1] = 3;
        I[224][2] = 10;
        I[225][0] = 1;
        I[225][1] = 3;
        I[225][2] = 10;
        I[226][0] = 3;
        I[226][1] = 3;
        I[226][2] = 10;
        I[227][0] = 1;
        I[227][1] = 5;
        I[227][2] = 16;
        I[228][0] = 3;
        I[228][1] = 5;
        I[228][2] = 18;
        I[229][0] = 1;
        I[229][1] = 3;
        I[229][2] = 12;

        I[230][0] = 2;
        I[230][1] = 2;
        I[230][2] = 7;
        I[231][0] = 1;
        I[231][1] = 3;
        I[231][2] = 12;
        I[232][0] = 1;
        I[232][1] = 3;
        I[232][2] = 10;
        I[233][0] = 1;
        I[233][1] = 1;
        I[233][2] = 6;
        I[234][0] = 3;
        I[234][1] = 3;
        I[234][2] = 10;
        I[235][0] = 1;
        I[235][1] = 1;
        I[235][2] = 4;
        I[236][0] = 3;
        I[236][1] = 5;
        I[236][2] = 18;
        I[237][0] = 0;
        I[237][1] = 0;
        I[237][2] = 0;
        I[238][0] = 2;
        I[238][1] = 2;
        I[238][2] = 7;
        I[239][0] = 1;
        I[239][1] = 3;
        I[239][2] = 12;

        I[240][0] = 1;
        I[240][1] = 3;
        I[240][2] = 10;
        I[241][0] = 1;
        I[241][1] = 3;
        I[241][2] = 10;
        I[242][0] = 3;
        I[242][1] = 3;
        I[242][2] = 10;
        I[243][0] = 1;
        I[243][1] = 1;
        I[243][2] = 4;
        I[244][0] = 3;
        I[244][1] = 5;
        I[244][2] = 18;
        I[245][0] = 1;
        I[245][1] = 3;
        I[245][2] = 12;
        I[246][0] = 2;
        I[246][1] = 2;
        I[246][2] = 7;
        I[247][0] = 1;
        I[247][1] = 3;
        I[247][2] = 12;
        I[248][0] = 1;
        I[248][1] = 3;
        I[248][2] = 10;
        I[249][0] = 1;
        I[249][1] = 1;
        I[249][2] = 6;

        I[250][0] = 3;
        I[250][1] = 3;
        I[250][2] = 10;
        I[251][0] = 1;
        I[251][1] = 1;
        I[251][2] = 4;
        I[252][0] = 3;
        I[252][1] = 5;
        I[252][2] = 18;
        I[253][0] = 0;
        I[253][1] = 0;
        I[253][2] = 0;
        I[254][0] = 2;
        I[254][1] = 2;
        I[254][2] = 7;
        I[255][0] = 1;
        I[255][1] = 3;
        I[255][2] = 12;
    }

    public String deleteSpace(String s) {
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && s.charAt(i) != '\t') {
                t = t + s.charAt(i);
            }
        }
        return t;

    }

    public int getIndexFromMnemonic(String s) {
        initHexcode();
        int i = 0;
        int hex = 0;
        for (i = 0; i < 256 && !s.equalsIgnoreCase(S[i]); i++);
        if (i == 256) {
            i = 0;
        }
        return i;

    }

    public String getHexCodeFromMnemonic(String s) {
        return Dec2Hex2digit(getIndexFromMnemonic(s));
    }

    public int Hex2Dec(String s)//Hexadecimal upto FF
    {

        try {
            if (s.equalsIgnoreCase("")) {
                s = "0";
            }
        } catch (Exception e) {
            s = "";
        }
        int no = 0;
        s = s.toUpperCase();
        for (int i = 0, n = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '0':
                    n = 0;
                    break;
                case '1':
                    n = 1;
                    break;
                case '2':
                    n = 2;
                    break;
                case '3':
                    n = 3;
                    break;
                case '4':
                    n = 4;
                    break;
                case '5':
                    n = 5;
                    break;
                case '6':
                    n = 6;
                    break;
                case '7':
                    n = 7;
                    break;
                case '8':
                    n = 8;
                    break;
                case '9':
                    n = 9;
                    break;
                case 'A':
                    n = 10;
                    break;
                case 'B':
                    n = 11;
                    break;
                case 'C':
                    n = 12;
                    break;
                case 'D':
                    n = 13;
                    break;
                case 'E':
                    n = 14;
                    break;
                case 'F':
                    n = 15;
                    break;
            }
            no = no * 16 + n;

        }
        return no;
    }

    public String Dec2Hex(int n)//decimal upto 255
    {
        String d[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        String s = "";
        for (; n > 0; n /= 16) {
            s = d[n % 16] + s;
        }
        int l = s.length();
        for (int i = 0; i < 4 - l; i++) {
            s = '0' + s;
        }
        return s;

    }

    public String Dec2Hex2digit(int n)//decimal upto 255
    {

        String d[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        String s = "";
        for (; n > 0 && s.length() < 2; n /= 16) {
            s = d[n % 16] + s;
        }
        int l = s.length();
        for (int i = 0; i < 2 - l; i++) {
            s = '0' + s;
        }

        return s;

    }

    public String Dec2Bin(int n) {

        String a = "";
        int l = 0;
        for (int i = 0; n > 0; i++, n /= 2) {
            a = (n % 2) + a;
        }
        l = 8 - (a.length() % 8);
        if (a.length() > 0 && a.length() % 8 == 0) {
            l = 0;
        }
        for (int i = 0; i < l; i++) {
            a = "0" + a;
        }
        return a;
    }

    public String Hex2Bin(String s) {

        return Dec2Bin(Hex2Dec(s));
    }

    public int Bin2Dec(String s) {
        long n = 0;
        try {
            long pow = 1, no = Long.parseLong(s);
            for (; no > 0; no /= 10) {

                n = n + (no % 10) * pow;
                pow *= 2;
            }
        } catch (Exception e) {
        }
        return (int) n;
    }

    public String Bin2Hex(String s) {
        return Dec2Hex(Bin2Dec(s));
    }

    public String Ascii2Hex(String s)
    {
        char c=s.charAt(s.length()-1);
        return Dec2Hex(c);
    }

    public String Hex2Ascii(String s)
    {
       return String.valueOf((char) Hex2Dec(s));
    }

    public String HexAutoCorrect4digit(String s) {
        String t = "";
        s = s.trim();

        if(s.length()>=4)t=s.substring(s.length()-4, s.length());
        /*for (int i = 0; i < 4 && i < s.length(); i++) {
            t = t + s.charAt(i);
        }*/
        return Dec2Hex(Hex2Dec(t));
    }

    public String HexAutoCorrect2digit(String s) {
        s = s.trim();

        return Dec2Hex2digit(Hex2Dec(s));
    }

    public boolean isHexadecimal(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!isHex(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String Label2Address(String s) {
        String t = s.trim();
        int[] value=parseOperator(s);      
        int index=value[0],operator=value[1],num=value[2];
        if(index>-1)t=s.substring(0, index).trim();        
        for (int i = 0; i < 65536; i++) {
            if (t.equalsIgnoreCase(m.label[i])) {
                return Dec2Hex(operate(i, num, (char)operator));
            }
        }
        return "";
    }
    
    public int[] parseOperator(String s)
    {
        int[] value=new int[3];
        int index=-1,operator=-1,num=0;
        try{
            if (s.indexOf('+')>-1){index=s.indexOf('+'); operator = '+';}
            if (s.indexOf('-')>-1){index=s.indexOf('-'); operator = '-';}
            if (s.indexOf('*')>-1){index=s.indexOf('*'); operator = '*';}
            if (s.indexOf('/')>-1){index=s.indexOf('/'); operator = '/';}
            num = Integer.parseInt(s.substring(index+1,s.length()).trim());
            }
        catch(Exception e){}
        value[0]=index;  value[1] = operator;  value[2] = num;
        return value;
    }
    
    public int operate(int a, int b,char operator)
    {
        int value=0;
        try{
            switch(operator){
            case '+': return value = a + b; 
            case '-': return value = a - b; 
            case '*': return value = a * b;
            case '/': return value = a / b;
            default: return a;
            }
        }catch(Exception e){return a;}
    }
        public String preLabel2Address(String s) {
        String t = s.trim();
        int[] value=parseOperator(s);      
        int index=value[0],operator=value[1],num=value[2];
        if(index>-1)t=s.substring(0, index).trim();        
        for (int i = 0; i < 500; i++) {
            if (t.equalsIgnoreCase(m.preLabel[i][0])) {
                return Dec2Hex(operate(convertToNum(m.preLabel[i][1]), num, (char)operator));

            }
        }
        return "";
    }
    
    public int convertToNum(String s){
        int num=0;
        s=s.trim();s=s.toUpperCase();
        num=Hex2Dec(s);
            if(s.charAt(s.length()-1)=='D')try{num=Integer.parseInt(s.substring(0, s.length()-1));}catch(Exception e){}
            else if(s.charAt(s.length()-1)=='B')num=Bin2Dec(s.substring(0, s.length()-1));
        if(s.charAt(s.length()-1)=='H')num=Hex2Dec(s.substring(0, s.length()-1));
        if(s.length()==2||s.length()==4)num=Hex2Dec(s.substring(0, s.length()));
        return num;
    }  
        

    public String Address2Label(String s) {
        return m.label[Hex2Dec(s)].toUpperCase();
    }

    /**
     *
     * @param s function
     * @return s[0] original repaired function,
     * @return s[1] lower byte,
     * @return s[2] upper byte,
     * @return s[3] index
     */
    public String[] MnemonicToHexcode(String s) {
        if (s == null) {
            s = "";
        }
        s = s.toUpperCase().trim();
        String p[] = {"", "", "", ""};
        String s0 = "", s2 = "", s4 = "";
        int n0 = 0, n2 = 0, n4 = 0;
        n0 = getIndexFromMnemonic(s);


        String label = "";
        int i = 0;

        int j = s.indexOf(',');
        if (j != -1) {
            s = s.substring(0, j).trim() + ',' + deleteSpace(s.substring(j + 1, s.length()));
        }

        for (i = s.length() - 1; i >= 0 && s.charAt(i) != ',' && s.charAt(i) != ' '; i--) {
            label = s.charAt(i) + label;
        }
        if (Label2Address(label).length() != 0) {
            s = s.substring(0, s.length() - label.length()) + Label2Address(label);
        }
        else if (preLabel2Address(label).length() != 0) {
            s = s.substring(0, s.length() - label.length()) + preLabel2Address(label);
        }
        
        if (n0 == 0) {
            if (s.length() > 2) {
                n2 = getIndexFromMnemonic(s.substring(0, s.length() - 2) + "XX");
            }
            if (s.length() > 4) {
                n4 = getIndexFromMnemonic(s.substring(0, s.length() - 4) + "XXXX");
            }
            if (n0 < n2) {
                n0 = n2;
            }
            if (n0 < n4) {
                n0 = n4;
            }
            if (!isHexadecimal(s.substring(i + 1, s.length()))) {
                n0 = 0;
            }
        }

        if (n0 == 0 && s.charAt(s.length() - 1) == 'D' && s.length() > 5) {
            try {

                if (getBytesFromMnemonics(s.substring(0, i + 1) + "XXXX") == 3 && Integer.parseInt(s.substring(i + 1, s.length() - 1)) < 65536) {
                    s = s.substring(0, i + 1) + Dec2Hex(Integer.parseInt(s.substring(i + 1, s.length() - 1))) + 'H';
                } else if (getBytesFromMnemonics(s.substring(0, i + 1) + "XX") == 2 && Integer.parseInt(s.substring(i + 1, s.length() - 1)) < 256) {
                    s = s.substring(0, i + 1) + Dec2Hex2digit(Integer.parseInt(s.substring(i + 1, s.length() - 1))) + 'H';
                }

            } catch (Exception e) {
            }
        }

        if (n0 == 0 && s.charAt(s.length() - 1) == 'B' && s.length() > 5) {

            if (isBinary(s.substring(i + 1, s.length() - 1))) {
                try {
                    if (getBytesFromMnemonics(s.substring(0, i + 1) + "XXXX") == 3 && (Bin2Dec((s.substring(i + 1, s.length() - 1))) < 65536)) {
                        s = s.substring(0, i + 1) + Dec2Hex(Bin2Dec(s.substring(i + 1, s.length() - 1))) + 'H';
                    } else if (getBytesFromMnemonics(s.substring(0, i + 1) + "XX") == 2 && (Bin2Dec((s.substring(i + 1, s.length() - 1))) < 256)) {
                        s = s.substring(0, i + 1) + Dec2Hex2digit(Bin2Dec(s.substring(i + 1, s.length() - 1))) + 'H';
                    }

                } catch (Exception e) {
                }
            }
        }

        if (n0 == 0 && s.charAt(s.length() - 1) == 'H' && s.length() > 5) {
            if (isHexadecimal(s.substring(i + 1, s.length() - 1))) {
                if (getBytesFromMnemonics(s.substring(0, i + 1) + "XXXX") == 3 && Hex2Dec((s.substring(i + 1, s.length() - 1))) < 65536) {
                    s = s.substring(0, i + 1) + Dec2Hex(Hex2Dec(s.substring(i + 1, s.length() - 1)));
                } else if (getBytesFromMnemonics(s.substring(0, i + 1) + "XX") == 2 && Hex2Dec((s.substring(i + 1, s.length() - 1))) < 256) {
                    s = s.substring(0, i + 1) + HexAutoCorrect2digit((s.substring(i + 1, s.length() - 1)));
                } else {
                    s = "";
                }
                if (s.length() > 2) {
                    n2 = getIndexFromMnemonic(s.substring(0, s.length() - 2) + "XX");
                }
                if (s.length() > 4) {
                    n4 = getIndexFromMnemonic(s.substring(0, s.length() - 4) + "XXXX");
                }
                if (n0 < n2) {
                    n0 = n2;
                }
                if (n0 < n4) {
                    n0 = n4;
                }
            }

        }
        if (n0 == 0 && s.length() > 5) {
            if (isHexadecimal(s.substring(i + 1, s.length()))) {
                if (getBytesFromMnemonics(s.substring(0, i + 1) + "XXXX") == 3 && Hex2Dec((s.substring(i + 1, s.length()))) < 65536) {
                    s = s.substring(0, i + 1) + Dec2Hex(Hex2Dec(s.substring(i + 1, s.length())));
                } else if (getBytesFromMnemonics(s.substring(0, i + 1) + "XX") == 2 && Hex2Dec((s.substring(i + 1, s.length()))) < 256) {
                    s = s.substring(0, i + 1) + HexAutoCorrect2digit((s.substring(i + 1, s.length())));
                } else {
                    s = "disable";
                }
                if (s.length() > 2) {
                    n2 = getIndexFromMnemonic(s.substring(0, s.length() - 2) + "XX");
                }
                if (s.length() > 4) {
                    n4 = getIndexFromMnemonic(s.substring(0, s.length() - 4) + "XXXX");
                }
                if (n0 < n2) {
                    n0 = n2;
                }
                if (n0 < n4) {
                    n0 = n4;
                }
            }

        }
        p[3] = String.valueOf(n0);
        int bytes = I[n0][0];
        if (bytes == 1) {
            p[0] = S[n0];
        } else if (bytes == 2) {
            p[1] = "" + s.charAt(s.length() - 2) + s.charAt(s.length() - 1);
            String value = HexAutoCorrect2digit(p[1]);
            p[0] = s.substring(0, s.length() - 2) + value;

        } else if (bytes == 3) {
            p[1] = "" + s.charAt(s.length() - 2) + s.charAt(s.length() - 1);
            p[2] = "" + s.charAt(s.length() - 4) + s.charAt(s.length() - 3);
            String value = HexAutoCorrect4digit(p[2] + p[1]);
            p[0] = s.substring(0, s.length() - 4) + value;
        }
        if (Label2Address(label).length() != 0) {

            if (s.length() > s.length() - (bytes - 1) * 2) {
                p[0] = s.substring(0, s.length() - (bytes - 1) * 2) + label;
            }
        }
        else if (preLabel2Address(label).length() != 0) {

            if (s.length() > s.length() - (bytes - 1) * 2) {
                p[0] = s.substring(0, s.length() - (bytes - 1) * 2) + label;
            }
        }
        
        return p;
    }

    public String funcLabeltofuncCode(String s) {
        String p[] = MnemonicToHexcode(s);
        String temp = S[Integer.parseInt(p[3])];
        if (temp.length() > 5) {
            if (temp.substring(temp.length() - 4, temp.length()).equalsIgnoreCase("XXXX")) {
                p[0] = temp.substring(0, temp.length() - 4);
                p[0] = p[0] + p[2] + p[1];
            }
            else if (temp.substring(temp.length() - 3, temp.length() - 1).equalsIgnoreCase("XX")) {
                p[0] = temp.substring(0, temp.length() - 2);
                p[0] = p[0] + p[1];
            }
        }
        return p[0];
    }

    public boolean isFunction(String s)
    {
        if(funcLabeltofuncCode(s).equalsIgnoreCase("NOP"))return false;
        else return true;
    }

    public int getBytesFromMnemonics(String s) {
        s = s.toUpperCase();

        int i, up, state = 1;
        yahoo:
        for (i = 00; i < 256; i++) {
            up = s.length() < S[i].length() ? s.length() : S[i].length();
            state = 1;

            for (int j = 0; j < up; j++) {

                if ((S[i].charAt(j) == s.charAt(j) || S[i].charAt(j) == 'X') && state == 1) {


                    state = 1;
                    if (S[i].charAt(j) == 'X' && S[i].charAt(j) != s.charAt(j) && s.charAt(j) != ' ') {


                        if (!Label2Address(s.substring(j, s.length())).equalsIgnoreCase("")) {

                            j = up - 1;
                        }
                    }

                    if (j == up - 1) {
                        break yahoo;
                    }

                } else {
                    state = 0;
                }

            }
        }
        if (i == 256) {
            i = 0;
        }
        return I[i][0];
    }

    /**label,code,comment,preprocessor
     * 
     * @param s
     * @return 
     */
    public String[] parseAssemblerContent(String s) {
        String[] filter = {"", "", "",""};
        try {
            if (s.length() == 0) {
                return filter;
            }
            s=s.replaceAll("\\s+"," ");
            
            int index_colon=s.indexOf(":");
            int index_slash=s.indexOf("//");
            int index_semicolon=s.indexOf(";");
                int index_comment= index_slash > index_semicolon ? index_slash : index_semicolon;
                int index_comment_end= index_slash > index_semicolon ? index_slash+2 : index_semicolon+1;
            if ( index_slash != -1  && index_semicolon != -1 ){
                index_comment= index_slash < index_semicolon ? index_slash : index_semicolon;
                index_comment_end= index_slash < index_semicolon ? index_slash+2 : index_semicolon+1;
            }
                
            int index_hash=s.indexOf("#");
            int index_dot=s.indexOf(".");        
                int index_preprocessor = index_hash > index_dot ? index_hash : (index_hash>-1 ? index_hash : index_dot);
            
            //preprocessor
            if (index_preprocessor > -1 && (index_comment>index_preprocessor || index_comment ==-1)) 
                if(index_comment > -1) {filter[3]=s.substring(index_preprocessor+1,index_comment).trim(); index_comment=0;}
                else {filter[3]=s.substring(index_preprocessor+1,s.length()).trim(); return filter;}
            //Comment
            if(index_comment > -1) {filter[2]=s.substring(index_comment_end,s.length()).trim();}else index_comment=s.length();
            
            //label
            if(index_colon > -1 && (index_comment>index_colon || index_comment ==-1)) 
                filter[0]=s.substring(0, index_colon);
            
            //Code
            if(index_comment<=index_colon) index_colon = -1;
            filter[1]=s.substring(index_colon+1,index_comment);
            filter[1] = filter[1].trim();

            return filter;
        } catch (Exception e) {
            System.out.println(s);
            
            filter[0] = "";
            filter[1] = "";
            filter[2] = "";
            filter[3] = "";
            return filter;
        }
    }

    public String HexToMnemonic(int func,int n1,int n2)
    {
        String s="";
        s=S[func];
        int bytes=I[func][0];
        if(bytes==3){
            s=s.substring(0, s.length()-4);
            s=s+Dec2Hex2digit(n2)+Dec2Hex2digit(n1);
        }
        else if(bytes==2){
            s=s.substring(0, s.length()-2);
            s=s+Dec2Hex2digit(n1);
        }
        return s;
    }

    public String HexToMnemonicWithLabel(int func,int n1,int n2)
    {
        String s=HexToMnemonic(func,n1,n2);
        if(!m.label[(n2*256+n1)&0xFFFF].equalsIgnoreCase("")&&I[func][0]==3)
            s=s.substring(0, s.length()-4)+m.label[(n2*256+n1)&0xFFFF].toUpperCase();
        return s;
    }
    public boolean isHex(char c) {
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                return true;
        }
        return false;
    }

    public boolean isBinary(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '1' && s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Assembler assembler = new Assembler();
        AssemblerEngine hexcode = new AssemblerEngine(new Matrix(assembler));
        assembler.dispose();
        //System.out.println(hexcode.getHexCodeFromMnemonic("RST 1"));
        //System.out.println(hexcode.Hex2Bin(""));
        //System.out.println(hexcode.Dec2Hex(53247));
        //System.out.println(hexcode.Dec2Bin(255));
        //System.out.println(hexcode.Bin2Dec("0001000"));
        //System.out.println(hexcode.HexAutoCorrect4digit("78"));
        hexcode.m.label[8900] = "start";
        hexcode.m.label[5000] = "xy";
        hexcode.m.preLabel[4][0] = "hello";hexcode.m.preLabel[4][1] = "5000D";
        
            String[] s = hexcode.MnemonicToHexcode("lxi h,XY");
            System.out.println(s[0] + " value2=" + s[1] + " value1=" + s[2] + " index=" + s[3]);
 
            s = hexcode.MnemonicToHexcode("lxi h,hello");
            System.out.println(s[0] + " value2=" + s[1] + " value1=" + s[2] + " index=" + s[3]);
        System.out.println(hexcode.getBytesFromMnemonics("lxi h,7890"));
        String[] x = hexcode.parseAssemblerContent("label:code    67 //comment");
        System.out.println("Label=" + x[0] + " Code=" + x[1] + " Comments=" + x[2]+" Compiler="+x[3]);
        
        x = hexcode.parseAssemblerContent("mvi a,23 #lxi h,xy*2 // hello");
        System.out.println("Label=" + x[0] + " Code=" + x[1] + " Comments=" + x[2]+" Compiler="+x[3]);

        x = hexcode.parseAssemblerContent("code    67 ;comment");
        System.out.println("Label=" + x[0] + " Code=" + x[1] + " Comments=" + x[2]+" Compiler="+x[3]); 
        
        x = hexcode.parseAssemblerContent("mvi a,77");
        System.out.println("Label=" + x[0] + " Code=" + x[1] + " Comments=" + x[2]+" Compiler="+x[3]);
        
        x = hexcode.parseAssemblerContent(". macrolabel: macro");
        System.out.println("Label=" + x[0] + " Code=" + x[1] + " Comments=" + x[2]+" Compiler="+x[3]);
        
        x = hexcode.parseAssemblerContent("# macro.125");
        System.out.println("Label=" + x[0] + " Code=" + x[1] + " Comments=" + x[2]+" Compiler="+x[3]);
        
        x = hexcode.parseAssemblerContent("code//comment 1: .comment 2");
        System.out.println("Label=" + x[0] + " Code=" + x[1] + " Comments=" + x[2]+" Compiler="+x[3]);
        
        x = hexcode.parseAssemblerContent("#compiler");
        System.out.println("Label=" + x[0] + " Code=" + x[1] + " Comments=" + x[2]+" Compiler="+x[3]);
        
        x = hexcode.parseAssemblerContent("//comment1:comment2#comment3;comment4");
        System.out.println("Label=" + x[0] + " Code=" + x[1] + " Comments=" + x[2]+" Compiler="+x[3]);
        System.out.println(hexcode.preLabel2Address("HELLO+2"));
        //System.out.println(hexcode.isHexadecimal("67efdac"));
        //System.out.println(hexcode.isBinary("1011"));
        //System.out.println(hexcode.funcLabeltofuncCode("adi 56"));
        //System.out.println(hexcode.HexToMnemonic(1, 23, 11));
        //System.out.println(hexcode.Dec2Bin(12345));
        //System.out.println("//jl".split("//")[1]);
    }
}
