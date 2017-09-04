//SHIFT AN 8-BIT NUMBER LEFT BY 2 BITS
//The number to be shifted is stored in C050
//Answer is stored in C051

                             LDA C050
                             ADD A	 //this cannot be achived by RLC
	ADD A
                             STA C051
                             HLT

//EXAMPLE-> C050=15
//Answer-> C051=54

# ORG C050
# DB 15H