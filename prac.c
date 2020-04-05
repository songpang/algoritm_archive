#include <stdio.h>
#include <string.h>

int main() {
  char a[100];

  scanf("%s", a);
    if(strcmp(a, "\n") == 0)
      printf("\n");
  return 0;

}