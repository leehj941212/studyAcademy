class ObjectOne{
	int a;
}

public class  ObjectInArray{
	public static void main(String[] args) {

		ObjectOne[] obj = new ObjectOne[5]; //按眉 硅凯阑 积己 (酒流 按眉 积己篮 救凳)
		System.out.println("obj = " + obj);

		for ( int i = 0 ; i < obj.length ; i++ ){
			System.out.print("积己傈 : obj[" + i + "] = " + obj[i]);
			obj[i] = new ObjectOne(); //按眉 积己
			System.out.println(", 积己饶 : obj[" + i + "] = " + obj[i]);
		}

		System.out.println();
		for ( int i = 0 ; i < obj.length ; i++ ){
			System.out.print("积己傈 : obj[" + i + "].a = " + obj[i].a);
			obj[i].a = i;
			System.out.println(", 积己饶 : obj[" + i + "].a = " + obj[i].a);
		}
		System.out.println();
		obj[0] = obj[1]; //按眉尝府档 措涝捞 啊瓷

		for ( int i = 0 ; i< obj.length ; i++){
			System.out.print("obj[" + i + "].a = " + obj[i]);
			System.out.println("==>obj[" + i + "].a = " + obj[i].a);
		}
	}
}
