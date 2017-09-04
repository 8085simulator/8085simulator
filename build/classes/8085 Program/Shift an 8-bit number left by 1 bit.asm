// SHIFT AN 8-BIT NUMBER LEFT BY 1 BIT
// The number to be shifted is stored in C050
// Answer is stored in C051
	   LDA C050
	   ADD A	// this cannot be achived by RLC
	   STA C051
	   HLT
// EXAMPLE-> C050=65
// Answer-> C051=CA

# ORG C050
# DB 65H
