// SHIFT AN 16-BIT NUMBER LEFT BY 2 BITS
// The number to be shifted is stored in C050 & C051
// Answer is stored in C052 & C053
	   LHLD C050
	   DAD H	// this cannot be achived by RLC
	   DAD H
	   SHLD C052
	   HLT
// EXAMPLE-> C050=96,C051=15
// Answer-> C052=58,C053=56

# ORG C050
# DB 96H,15H
