#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(){

        char buffer[1000];
        printf("Enter a String: ");
        fgets(buffer, 1000, stdin);

        printf("Before: %s\n", buffer);
        char *str = buffer;
        
        while(*str != '\0') {
                *str = toupper(*str); 
                str++;
        }        
        printf("After: %s\n", buffer);
        
        return 0;
}