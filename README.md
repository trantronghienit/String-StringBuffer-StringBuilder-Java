# Tổng Quan Về String-StringBuffer-StringBuilder Java
 Trong Java

![cay quan h string](https://cloud.githubusercontent.com/assets/18228937/17828846/396448e0-66c7-11e6-8962-29c022b2121f.png)

## 1. String Là Gì ?
String là một dãy hoặc một mảng gồm các kí tự. __Kí tự cuối cùng là kí tự \0__(NULL trong bảng mã ASCII).

## 2. Cấp Phát Vùng Nhớ Trong String ?

![example](https://cloud.githubusercontent.com/assets/18228937/17818182/9e05f9b6-666c-11e6-9a02-870be4246e76.png)</br>

### * giải thích cho kết quả trên
<img width="584" alt="string-pool-java1" src="https://cloud.githubusercontent.com/assets/18228937/17818126/5af5b760-666c-11e6-81a3-7d561279b23c.png">

### * String Literal & String Pool

Khi bạn khởi tạo một biến String với chuỗi nằm trong dấu ngoặc kép ” ” (ví dụ: String s = “heloo”) 
tức là bạn đang khởi tạo một đối tượng String Literal và đối tượng String này được cất giữ ở trong một vùng nhớ đặc biệt
gọi là String Pool. 
_Mỗi khi bạn khởi tạo một String Literal tiếp theo, JVM sẽ kiểm tra String Pool;
nếu chuỗi đã tồn tại trong Pool, một tham chiếu tới String Literal tương ứng được trả về, 
nếu không JVM sẽ khởi tạo một đối tượng String mới và đặt nó vào trong Pool_

* Tại sao là String Literal?
  * String Literal khiến việc quản lí bộ nhớ của JVM được hiệu quả hơn
  * Giá trị của một đối tượng String không bao giờ thay đổi!
  * Tất cả các hàm sử lí chuỗi có sẵn của lớp String đều ***trả về một đối tượng String mới*** nhưng ***không làm thay đổi giá trị*** của String đã cho.
  
vd:

![string literal](https://cloud.githubusercontent.com/assets/18228937/17818888/a7a16a34-666f-11e6-8687-d4ada8a71b7f.png)

==> tuy nhiên có thể dùng nó để tham chiếu chính nó để hứng giá trị mới `temp = temp.toUpCase();  `

## 3. Một Số Phương Thức có sẳn trong Lớp String để sử lý chuổi:
String s = " demo.vn   ";
* Hàm __Nối Chuỗi__
 * concat(String chuoicannoi) Trả về một String mới có giá trị là: s + chuoicannoi
* Hàm __thay thế__ những chuỗi con bằng một chuỗi mới
  * 1. replace(String oldString, String newString)
  * 2. replaceFirst(String regex, String replacement)
  * 3. String replaceAll(String regex, String replacement)
vidụ: 
```
 public static void main(String[] args) {
	String string_Literal = "hien tran it at ";
	// thay thế các kí tự là i thành o
	System.out.println("kết quả: " + string_Literal.replace("i", "o"));
	// thay thế các kí tự đầu tiên là en thành abc
	System.out.println("kết quả: " + string_Literal.replaceFirst("en", "abc"));
	System.out.println("kết quả: " + string_Literal.replace("en", "abc"));
	// thay thế các kí tự it|at thành "+"
	System.out.println("kết quả: " + string_Literal.replaceAll("it|at" , "+"));
}
Kết quả:

kết quả: hoen tran ot at 
kết quả: hiabc tran it at 
kết quả: hiabc tran it at 
kết quả: hien tran + + 

```
*Hàm __trả về kí tự__ tại một vị trí nào đó (vị trí index được truyền vào)
  * charAt(int index)
 
* Hàm __cắt bỏ__ khoảng trống thừa 2 đầu
  * trim():

* Hàm __lấy mã ASCII__
 * codePointAt(int index)
 * vd : s.codePointAt(0) trả về 66 (mã ASCII của ‘B’ là 66)
 
* Hàm __kiểm tra một chuỗi__ có tồn tại trong chuỗi
 * contains(String anotherString)
 * Hàm __kiểm tra__ một chuỗi có tồn tại trong chuỗi đã cho hay không, Nếu tồn tại trả về TRUE, nếu không trả về FALSE.
 * vd : s.contains(“d.vn”) trả về TRUE

* Hàm  __so sánh__ String này với đối tượng Object khác
 * trả về 0 tham số là một chuỗi cân bằng với chuỗi "theo từ điển"
 * trả về một giá trị nhỏ hơn 0 nếu tham số là một chuỗi lớn hơn "theo từ điển"
 * một giá trị lớn hơn 0 nếu tham số là một chuỗi "theo từ điển". 
``` 
int compareTo(Object đối tượng cần so sánh)
or
int compareTo(String String để được so sánh)
```

* Hàm __Cắt chuỗi__
```
public String[] split(String regex, int limit)
or
public String[] split(String regex)
regex -- Là Regular expression phân giới.
limit -- Bao nhiêu chuỗi được trả về.
Nó trả về một mảng các chuỗi được tính toán bằng việc chia chuỗi này xung quanh các so khớp của regular expression đã cho
``` 
code demo
```
 public class ViduSpit1{  
public static void main(String args[]){  
String s1="Vi du Split boi Vietjack.com";  
String[] words=s1.split("\\s");//chia chuoi dua tren string phan cac nhau boi khoang trang (\\s) 
for(String w:words){  
System.out.println(w);  
}  
}}  
```
* Hàm __So Sánh Chuỗi__
 * public boolean equals(Object đối tượng cần so sánh)
 * public boolean equalsIgnoreCase(String đối tượng cần so sánh)  // không phân biệt chữ thường chữ hoa

* Hàm __trả về một chuỗi mới__ mà là một chuỗi phụ của chuỗi này
```
public String substring(int beginIndex)
or
public String substring(int beginIndex, int endIndex)
beginIndex -- Chỉ mục bắt đầu.
endIndex -- Chỉ mục cuối.
```
code demo :
```
public class ViduSubString{  
public static void main(String args[]){  
String s1="HienTran";  
System.out.println(s1.substring(2,4)); //tra ve in  
System.out.println(s1.substring(2)); // ienTran
}}
kết quả :
in 
ienTran
```
* Hàm trả về giá trị __Hash code__ cho đối tượng 
 * trả về một mã hóa băm (hash code) cho chuỗi này
 * public int hashCode()
demo :
```
public class Test{
   public static void main(String[] args) {
		String string_Literal = "hien tran";
		System.out.println("hash code " + string_Literal.hashCode());
	}
}
kết quả :
hash code 1940674593
```
* Hàm __Chuyển chuỗi __này thành mảng ký tự.
 * char[] toCharArray()
* Hàm __Kiểm tra nếu chuỗi này bắt đầu__ với tiền tố quy định
 * 1. boolean startsWith(String prefix)
   * prefix : tiền tố cần kiểm tra
 * 2. boolean startsWith(String prefix, int toffset)
   * prefix : tiền tố cần kiểm tra
   * toffset : bắt đầu một chỉ số xác định
   

code demo:
```
public static void main(String[] args) {
		String string_Literal = "hien tran";
		System.out.println("kiem tra : " + string_Literal.startsWith("hi"));
		System.out.println("kiem tra " + string_Literal.startsWith("h", 0));
	}
kết quả :
kiem tra : true
kiem tra true

```
* Hàm Kiểm Trả xem có đúng với chuẩn định nghĩa không
 * public boolean matches(String regex)
   * regex : chuẩn định nghĩa
```
	String chuoi = "Tran Trong Hien";
        System.out.println("" + chuoi.matches("(.*)Trong(.*)")); 
	System.out.println("" + chuoi.matches("Trong")); 
	
	kết quả:
	true
	false
```   
* ***Tìm Index(vị trí)*** của 1 kí tự 1 chuổi
 * int indexOf(String str)
 * int indexOf(String str, int fromIndex)
 	* trường hớp nếu tìm không thấy trả về -1 
  * ví du:
```
                 0                   20
 String chuoi = "Tran Trong Hien Dep Trai";
        System.out.println("" + chuoi.indexOf(1)); 
        System.out.println("" + chuoi.indexOf("T"));   
        System.out.println("" + chuoi.indexOf("T" , 9));  // tìm "T" từ index thứ 9 trở đi 
	
	Kết quả :
	-1
	0
	20
==============
	String text = "0123hello9012hello8901hello7890";
	String word = "hello";

	System.out.println(text.indexOf(word)); // prints "4"
	System.out.println(text.lastIndexOf(word)); // prints "22"

	// tìm tất cả số lần xuất hiện bắt đầu tìm từ phía trước
	for (int i = -1; (i = text.indexOf(word, i + 1)) != -1; ) {
    		System.out.println(i);
	} // prints "4", "13", "22"

	// tìm tất cả số lần xuất hiện bắt đầu tìm từ phía sau
	for (int i = text.length(); (i = text.lastIndexOf(word, i - 1)) != -1; ) {
    		System.out.println(i);
	} // prints "22", "13", "4"
	
```
* Hàm  join()  Nối chuổi bởi dấu phân tách (java 8) </br>
vd: 
```
public static void main(String args[]) {
        String joinString1 = String.join("-", "welcome", "to", "java");
        System.out.println(joinString1);
    }

// =======================
kết quả:
welcome-to-java
```

* Hàm intern() có thể được sử dụng để trả về chuỗi từ Pool chứa hằng số chuỗi khi nó được tạo bởi từ khóa new
vd: 
```
public static void main(String args[]) {
        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = s1.intern();//trả về chuỗi từ Pool
        System.out.println(s1 == s2);//false vì reference là khác nhau
        System.out.println(s2 == s3);//true vì reference là giống nhau 
    }
=====================
kết quả:
false
true
```
* Hàm formart() trả về một chuỗi được format theo miền địa phương.
vd 
```
 public static void main(String args[]) {
        String name = "sonoo";
        String sf1 = String.format("name is %s", name);
        String sf2 = String.format("value is %f", 32.33434);
        String sf3 = String.format("value is %32.12f", 32.33434);
 
        System.out.println(sf1);
        System.out.println(sf2);
        System.out.println(sf3);
    }
====================
kết quả:
name is sonoo
value is 32.334340
value is                  32.334340000000
```


Tham khảo Thêm : </br>
![java-memory-stack-heap](https://cloud.githubusercontent.com/assets/18228937/17819613/e6cf3eae-6672-11e6-8c01-06afae34b92c.jpg)

-------------------------------------------------
## 4. String buffer & String builder.
Như ta đã biết đối tượng String là không thể thay đổi Nhưng String buffer & String builder __lại có thể thay đổi__

* với trường hợp tham chiếu chính nó trong String 
![proformance](https://cloud.githubusercontent.com/assets/18228937/17828766/46dab100-66c5-11e6-97bb-a5cbf34f5c1b.png)

### tại sao dùng String buffer & String builder .
* String khi mỗi lần nối thêm chuỗi nó tạo ra instance mới xử lý chậm và tốn nhiều bộ nhớ . với bài toán hiệu suất như trên StringBuilder hoặc StringBuffer sẽ giúp bạn giải quyết vấn đề về hiệu suất.

### khi nào nên dùng ?
* Khi bạn thực hiện nối nhiều chuỗi thì lớp StringBuffer xử lý nhanh và tốn ít bộ nhớ hơn.

### * Tại sao vậy?
hai lớp trên đều thuộc lọai mutable(có thể thay đổi được) Nhờ đặc tính này mà khi thay đổi các chuỗi trong những đối tượng này JVM __không phải tạo các đối tượng mới (đối tượng tạm)__ và vấn đề về performance.

### vậy StringBuffer và String builder khác gì nhau ?
* StringBuffer thuộc loại synchronized do đó các phương thức của nó đều là an toàn luồng "thread safe" Nghĩa là hai Thread không thể gọi đồng thời các phương thức của lớp StringBuffer __(thích hợp với xử lý đa luồng – multi thread).__

* StringBuilder thì ngược lại, non-synchronized hai Thread có thể gọi đồng thời các phương thức của lớp StringBuilder .__(không thích hợp với xử lý đa luồng)__, các phương thức của StringBuffer sẽ chạy chậm hơn so với StringBuilder. </br>
==>vì StringBuilder thuộc loại đa luồng  nhưng non-synchronized nên sẽ nhanh hơn StringBuffer là loại synchronized tuy theo tình huống mà sử dụng  StringBuffer và StringBuilder cho đúng .
 
demo :
```
StringBuffer buffer = new StringBuffer("trua nay an gi ?");
	buffer.append(" an com");
	System.out.println("ket qua:"+ buffer);
ket qua:trua nay an gi ? an com
```

### phương Thức
có một số phương thức giống String , StringBuffer và StringBuilder giống nhau

![phuong thuc thuong gap trong stringbuffer stringbuilder](https://cloud.githubusercontent.com/assets/18228937/17829121/8447473e-66ce-11e6-812c-af900167dab3.png)

* Hàm replace() ***thay thế*** chuỗi bằng chuỗi khác từ vị trị bắt đầu và kết thúc được quy định .
```
public static void main(String args[]) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.replace(1, 3, "Java");
        System.out.println(sb);//in 
    }
=========kết quả========
HJavalo 
```

* Phương thức reverse() của lớp StringBuffer ***đảo ngược chuỗi*** hiện tại.
```
public static void main(String args[]) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.reverse();
        System.out.println(sb);
    }
===========
olleH 
```

* Hàm capacity() của lớp StringBuffer trả về ***dung lượng của bộ nhớ đệm*** </br>
Phương thức capacity() của lớp StringBuffer trả về dung lượng của bộ nhớ đệm. Dung lượng mặc định của bộ nhớ đệm là 16. Nếu số lượng ký tự của chuỗi tăng lên thì dung lượng được tính theo công thức (dung lượng cũ*2)+2. Ví dụ: Nếu dung lượng hiện tại là 16, nó sẽ tăng lên (16*2)+2=34.
```
public static void main(String args[]) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());//mặc định là 16 
        sb.append("Hello");
        System.out.println(sb.capacity());//đến đây vẫn là 16 
        sb.append("java is my favourite language");
        System.out.println(sb.capacity());//đến đây là (16*2)+2=34 i.e (dung lượng cũ*2)+2 
    }
```

* Hàm ensureCapacity() đảm bảo rằng dung lượng đã cho là tối thiểu với dung lượng hiện tại.</br>

Phương thức ensureCapacity() của lớp StringBuffer đảm bảo rằng dung lượng đã cho là tối thiểu với dung lượng hiện tại. Nếu nó lớn hơn dung lượng hiện tại, dung lượng hiện tại được tăng theo công thức (dung lượng cũ*2)+2. Ví dụ, dung lượng hiện tại là 16, nó sẽ tăng lên là (16*2)+2=34.
```
public static void main(String args[]) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());//mặc định là 16 
        sb.append("Hello");
        System.out.println(sb.capacity());//đến đây là 16 
        sb.append("java is my favourite language");
        System.out.println(sb.capacity());//đến đây là (16*2)+2=34 i.e (dung lượng cũ*2)+2 
        sb.ensureCapacity(10);//đến đây không có sự thay đổi
        System.out.println(sb.capacity());//đến đây là 34 
        sb.ensureCapacity(50);//đến đây là (34*2)+2 
        System.out.println(sb.capacity());//đến đây là 70 
    }
```
