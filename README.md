# Tổng Quan Về String Trong Java

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
* Hàm Nối Chuỗi
 * concat(String chuoicannoi) Trả về một String mới có giá trị là: s + chuoicannoi
* Hàm thay thế những chuỗi con bằng một chuỗi mới
  * replace(String oldString, String newString)
  * Ví dụ: kết quả của s.replace(“vn”, “com”) là “demo.com”
*Hàm trả về kí tự tại một vị trí nào đó (vị trí index được truyền vào)
  * charAt(int index)
* Hàm cắt bỏ khoảng trống thừa 2 đầu
  * trim():
* Hàm lấy mã ASCII
 * codePointAt(int index)
 * vd : s.codePointAt(0) trả về 66 (mã ASCII của ‘B’ là 66)
* Hàm kiểm tra một chuỗi có tồn tại trong chuỗi
 * contains(String anotherString)
 * Hàm kiểm tra một chuỗi có tồn tại trong chuỗi đã cho hay không, Nếu tồn tại trả về TRUE, nếu không trả về FALSE.
 * vd : s.contains(“d.vn”) trả về TRUE
* Hàm  so sánh String này với đối tượng Object khác
``` 
int compareTo(Object đối tượng cần so sánh)
or
int compareTo(String String để được so sánh)
```
 * trả về 0 tham số là một chuỗi cân bằng với chuỗi "theo từ điển"
 * trả về một giá trị nhỏ hơn 0 nếu tham số là một chuỗi lớn hơn "theo từ điển"
 * một giá trị lớn hơn 0 nếu tham số là một chuỗi "theo từ điển".
* Hàm Cắt chuỗi
```
public String[] split(String regex, int limit)
or
public String[] split(String regex)
regex -- Là Regular expression phân giới.
limit -- Bao nhiêu chuỗi được trả về.
Nó trả về một mảng các chuỗi được tính toán bằng việc chia chuỗi này xung quanh các so khớp của regular expression đã cho
``` 
 * code demo
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
* So Sánh Chuổi 
 * public boolean equals(Object đối tượng cần so sánh)
 * public boolean equalsIgnoreCase(String đối tượng cần so sánh)  // không phân biệt chữ thường chữ hoa
*  trả về một chuỗi mới mà là một chuỗi phụ của chuỗi này
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
```
* Hàm trả về giá trị Hash code cho đối tượng 
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
Tham khảo Thêm : </br>
![java-memory-stack-heap](https://cloud.githubusercontent.com/assets/18228937/17819613/e6cf3eae-6672-11e6-8c01-06afae34b92c.jpg)

-------------------------------------------------
## 4. String buffer & String builder.


 
  
  
