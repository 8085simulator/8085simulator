// 1's COMPLEMENT OF AN 8-BIT NUMBER
// The number to be complemented is stored in C050
// Answer is stored in C051
	   LDA C050
	   CMA
	   STA C051
	   HLT
// EXAMPLE-> C050=96
// Answer-> C051=69

# ORG C050
# DB 96H
