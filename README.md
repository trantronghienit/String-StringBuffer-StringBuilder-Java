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
 
Tham khảo Thêm : </br>
![java-memory-stack-heap](https://cloud.githubusercontent.com/assets/18228937/17819613/e6cf3eae-6672-11e6-8c01-06afae34b92c.jpg)

-------------------------------------------------
## 4. String buffer & String builder.


 
  
  
