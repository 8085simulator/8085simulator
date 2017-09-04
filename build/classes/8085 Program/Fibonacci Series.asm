// FIBONACCI SERIES GENERATION

START:	   MVI C,09	// Counter
	   LXI H,C050	// Memory Pointer

X:	   MOV A,M
	   INX H
	   MOV B,M
	   INX H
	   ADD B
	   DAA
	   MOV M,A
	   DCX H
	   DCR C
	   JNZ X
	   RST 1
// To run the Program simply load at memory location C050=01,C051=01

# ORG C050
# DB 01H,01H
