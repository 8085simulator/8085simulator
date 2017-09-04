// ADDITION OF TWO 16BIT NUMBERS SUM 16 BITS OR MORE
// Manually strore 1st 16 bit no in the memory location C050 & C051 in reverse order
// Manually store 2nd 16 bit no in the memory location C052 & C053 in reverse order
// Result is stored in C053, C054 & C055 in reverse order
	   LHLD C050
	   XCHG
	   LHLD C052
	   MVI C,00
	   DAD D
	   JNC AHEAD
	   INR C

AHEAD:	   SHLD C054
	   MOV A,C
	   STA C056
	   HLT
// EXAMPLE-> A645+9B23=014168
// STORE-> C050=45,C051=A6,C052=23,C053=9B
// Answer-> C054=68,C055=41,C056=01

# ORG C050
# DB 45H,A6H,23H,9BH
