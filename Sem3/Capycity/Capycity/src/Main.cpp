#include "Capycity.h"



int main(int argc, char **argv)
{
	
		int length = std::atoi(argv[1]); 
		int width = std::atoi(argv[2]);
	
		Capycity capycity = Capycity(length, width);
	
		capycity.Run();



}