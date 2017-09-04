// MASK OFF MOST SIGNIFICANT 4 BITS OF AN 8-BIT NUMBER
// The number to be masked is stored in C050
// Answer is stored in C051
	   LDA C050
	   ANI 0F
	   STA C051
	   HLT
// EXAMPLE-> C050=96
// Answer-> C051=06

# ORG C050
# DB 96H
