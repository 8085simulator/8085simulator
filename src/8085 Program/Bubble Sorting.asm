// BUBBLE SORTING
// Store from memory location C020 five consecutive nos to be sorted in ascending orde

START:	   MVI D,05	// Counter

W:	   LXI H,C020
	   MVI C,05	// Counter

X:	   MOV A,M
	   INX H
	   MOV B,M
	   CMP B
	   JM Y
	   MOV M,A
	   DCX H
	   MOV M,B
	   INX H

Y:	   DCR C
	   JNZ X
	   DCR D
	   JNZ W
	   HLT
// EXAMPLE C020 -> BBH,AAH,99H,88H,77H,66H
// ANSWER C020 -> 66H,77H,88H,99H,AAH,BBH

# ORG C020
# DB BBH,AAH,99H,88H,77H,66H
