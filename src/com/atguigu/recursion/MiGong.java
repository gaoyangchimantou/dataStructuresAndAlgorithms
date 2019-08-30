package com.atguigu.recursion;

public class MiGong {

	public static void main(String[] args) {
		// ??????????????飬??????
		// ???
		int[][] map = new int[8][7];
		// ???1 ????
		// ??????????1
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}

		// ??????????1
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		//???????, 1 ???
		map[3][1] = 1;
		map[3][2] = 1;
//		map[1][2] = 1;
//		map[2][2] = 1;
		
		// ??????
		System.out.println("????????");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		//?????????С????·
		//setWay(map, 1, 1);
		setWay2(map, 1, 1);
		
		//????????, С??????????????????
		System.out.println("С???????????????? ????????");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	//????????????С????·
	//???
	//1. map ??????
	//2. i,j ????????????λ???????? (1,1)
	//3. ???С????? map[6][5] λ?????????·???.
	//4. ????? ??map[i][j] ? 0 ???????????? ??? 1 ????  ?? 2 ????·?????? ?? 3 ??????????????????????
	//5. ???????????????????????(????) ??->??->??->?? , ?????????????????
	/**
	 * 
	 * @param map ??????
	 * @param i ?????λ??????
	 * @param j 
	 * @return ???????·???????true, ?????false
	 */
	public static boolean setWay(int[][] map, int i, int j) {
		if(map[6][5] == 2) { // ?·??????ok
			return true;
		} else {
			if(map[i][j] == 0) { //?????????????????
				//??????? ??->??->??->??  ??
				map[i][j] = 2; // ??????????????.
				if(setWay(map, i+1, j)) {//??????
					return true;
				} else if (setWay(map, i, j+1)) { //??????
					return true;
				} else if (setWay(map, i-1, j)) { //????
					return true;
				} else if (setWay(map, i, j-1)){ // ??????
					return true;
				} else {
					//??????????????????·
					map[i][j] = 3;
					return false;
				}
			} else { // ???map[i][j] != 0 , ?????? 1?? 2?? 3
				return false;
			}
		}
	}
	
	//?????·????????? ??->??->??->??
	public static boolean setWay2(int[][] map, int i, int j) {
		if(map[6][5] == 2) { // ?·??????ok
			return true;
		} else {
			if(map[i][j] == 0) { //?????????????????
				//??????? ??->??->??->??
				map[i][j] = 2; // ??????????????.
				if(setWay2(map, i-1, j)) {//??????
					return true;
				} else if (setWay2(map, i, j+1)) { //??????
					return true;
				} else if (setWay2(map, i+1, j)) { //????
					return true;
				} else if (setWay2(map, i, j-1)){ // ??????
					return true;
				} else {
					//??????????????????·
					map[i][j] = 3;
					return false;
				}
			} else { // ???map[i][j] != 0 , ?????? 1?? 2?? 3
				return false;
			}
		}
	}

}
