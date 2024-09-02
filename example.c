#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

        char *s = "Je m'appelle Henry";
        puts("String in reverse is: ");
        for(int i = strlen(s) - 1; i >= 0 ; i--){
                printf("%c", s[i]);
        }
        printf("\n");
        return 0;
}