# JavaRush
CAESAR'S CIPHER v1.0.0


Program features:

- the program encodes/decodes a text file using the Caesar Cipher
- you can encrypt the text of any European language, including upper and lower case letters, spaces and punctuation marks 
- ( . , « » " ' : ! ? )
- the language of the text for encryption is determined by the program automatically (polylingualism)
- the encryption key can be specified from - 2 147 483 000 to 2 147 483 000
- commands with which the program works: ENCRYPT, DECRYPT, BRUTE_FORCE
- the program works from the command line as well as with received arguments
- to pass arguments, it is necessary to enter through a space: the command (ENCRYPT / DECRYPT / BRUTE_FORCE), the path to the file (filepath), the encoding key (key). There is no need to enter the encryption key for the BRUTE_FORCE command, the program itself determines with which key the text was encrypted
- as a result of the program, a file with the same name as the input file appears in the folder with the initial file, but with the mark [ENCRYPTED] / [DECRYPTED] according to the command specified by the program
- after decoding the encrypted file, the content of the text is not lost by a single character, so you can not worry about losing valuable information in the text transmitted to the program for encryption
- expect a user-friendly interface in the next version
- the test file for testing the program is in the folder: src/main/resources/test.txt
