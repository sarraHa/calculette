
int i ;

int f( int x, int y){


	int e = 2;
	return 2*x + y;
}



int g( int x, int y){


	int s = 4*5;
	return x + y;
}


int h( int x, int y, int z){


	int s = 4*5;
	return x + y + z;
}

int g = g( 5 , 2);
println(g);

int f = f( 5 , 2);
println(f);

int h = h( 5 , 2, 3);
println(h);


for(i=0 ; i < 5; i=i+1){

	int k = g( i , i + 1 );
	println(k);

} 


