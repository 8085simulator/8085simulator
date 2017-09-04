// SHIFT AN 16-BIT NUMBER LEFT BY 1 BIT
// The number to be shifted is stored in C050 & C051
// Answer is stored in C052 & C053
	   LHLD C050
	   DAD H	// this cannot be achived by RLC
	   SHLD C052
	   HLT
// EXAMPLE-> C050=96,C051=75
// Answer-> C052=2C,C053=EB

# ORG C050
# DB 96H,75H
