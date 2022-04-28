import java.util.*;
import java.lang.Math;

    class Ch03_Exercise {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            outer:
            while(true) {
                System.out.print("문제 번호(1~10)를 입력하세요.(종료:0)>");
                int num = scanner.nextInt();
                switch(num) {
                    case  0: break outer;
                    case  1: Exercise1(); break;
                    case  2: Exercise2(); break;
                    case  3: Exercise3(); break;
                    case  4: Exercise4(); break;
                    case  5: Exercise5(); break;
                    case  6: Exercise6(); break;
                    case  7: Exercise7(); break;
                    case  8: Exercise8(); break;
                    case  9: Exercise9(); break;
                    case 10: Exercise10(); break;
                }
            }
        }

        /* Exercise 3-1. 다음 연산의 결과를 적으시오 */
        private static void Exercise1() {
            int x = 2;
            int y = 5;
            char c = 'A';	// 'A'의 문자코드는 65

            System.out.println(1 + x << 33);			// 3에서 <<연사자로 33번 이동-> int가 32비트이므로 1비트만큼 남음 3*2=6
            System.out.println(y>=5 || x<0 && x>2);		// &&첫번째 연산자 false 두번째 논리연산자  true ||에서 true 이므로 최종 true
            System.out.println(y += 10 - x++);			// (y= y+10 -> 15) - 2= 13
            System.out.println(x += 2);					// 후위연산자로 x가 3이 되었으므로 x = 3+2 -> 5
            System.out.println(!('A'<=c && c<='Z'));	// 두 연산자 모두 true이지만 !인해 false
            System.out.println('C'-c);					// 67 - 65 ==2
            System.out.println('5'-'0');				// 63 - 48 == 5
            System.out.println(c+1);					// 1로 인해 int형으로 출력되므로 65+1==66
            System.out.println(++c);					// B
            System.out.println(c++);					// B
            System.out.println(c);						// 후위연산자로 인해 char형 C
        }

        /* Exercise 3-2. 아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다.
         * 만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면, 13개의 바구니가 필요할 것이다.
         * (1)에 알맞은 코드를 넣으시오.
         */
        private static void Exercise2() {
            int numOfApples = 123;	// 사과의 개수
            int sizeOfBucket = 10;	// 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
            int numOfBucket2 =  numOfApples/sizeOfBucket + (numOfApples%sizeOfBucket==0?0:1); //나누기 + 3항 연산자 사용
            System.out.println("필요한 바구니의 수2 : " + numOfBucket2);
        }

        /* Exercise 3-3. 아래는 변수 num의 값에 따라 '양수', '음수', '0'을 출력하는 코드이다.
         * 삼항 연산자를 이용해서 (1)에 알맞은 코드를 넣으시오.
         * [Hint] 삼항 연산자를 두 번 사용하기
         */
        private static void Exercise3() {
            int num = 10;
            System.out.println( num>0 ? "양수" : (num<0 ? "음수" : "0")); // 3항 연산자
        }

        /* Exercise 3-4. 아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다.
         * 만일 변수 num의 값이 '456'이라면 '400'이 되고, '111'이라면 '100'이 된다.
         * (1)에 알맞은 코드를 넣으시오.
         */
        private static void Exercise4() {
            int num = 456;
            System.out.println( (num/100)*100); //int형이 나머지를 버리는 것을 이용하여 100을 나눈후 100의 자리수만 남기고 다시 100을 곱함
        }

        /* Exercise 3-5. 아래는 변수 num의 값 중에서 일의 자리를 1로 바꾸는 코드이다.
         * 만일 변수 num의 값이 333이라면 331이 되고, 777이라면 771이 된다.
         * (1)에 알맞은 코드를 넣으시오.
         */
        private static void Exercise5() {
            int num = 333;
            System.out.println( (num/10)*10 + 1); //3-4랑 같은 방법
        }

        /* Exercis 3-6. 아래는 변수 num의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num의 값을 뺀 나머지를 구하는 코드이다.
         * 예를 들어, 24의 크면서도 가장 가까운 10의 배수는 30이다. 19의 경우 20이고, 81의 경우 90이 된다.
         * 30에서 24를 뺀 나머지가 6이기 때문에 변수 num의 값이 24라면 6을 결과로 얻어야 한다.
         * (1)에 알맞은 코드를 넣으시오.
         * [Hint] 나머지 연산자를 사용하라.
         */
        private static void Exercise6() {
            int num = 24;
            System.out.println(10 - num%10); //10에 num%나머지 연산자를 빼주면 답이 나온다
        }

        /* Exercise 3-7. 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다.
         * 변환 공식이 'C = 5/9 * (F-32)' 라고 할 때, (1)에 알맞은 코드를 넣으시오.
         * 단, 변환 결과값은 소수점 셋째자리에서 반올림 해야 한다.
         * (Math.round()를 사용하지 않고 처리할 것)
         */
        private static void Exercise7() {
            int fahrenheit = 100;
            float celcius =  (int)(((fahrenheit-32f)*5/9)*100+0.5)/100f;  // 100 곱한 다음 반올림일 한단음 int형으로 바
            // 꾼다움 100f으로 나누어서 섭씨온도 계산

            System.out.println("Farenheit : " + fahrenheit);
            System.out.println("Celcius : " + celcius);
        }

        /* Exercise 3-8. 아래 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오.
         * [실행결과]
         * c=30
         * ch=C
         * f=1.5
         * l=27000000000
         * result=true
         */
        private static void Exercise8() {
            byte a = 10;
            byte b = 20;
            //byte c = a + b;
            byte c = (byte)(a + b); //형변환

            char ch = 'A';
            //ch = ch + 2;
            ch = (char)(ch + 2); //형변환

            //float f = 3 / 2;
            float f = 3 / 2f; //1.5를 계산을 위해 2만 float 로 형변환
            //long l = 3000 * 3000 * 3000;
            long l = 3000 * 3000 * 3000l; // long이므로 접미에 l삽입

            float f2 = 0.1f;
            double d = 0.1;

            //boolean result = d==f2;
            boolean result = (float)d==f2; //boolean으로 int형으로 계산됨, f2는 이미 접미에 f가 있어서 형변환 필요없으나 d는 float로 형변환 해준다.

            System.out.println("c="+c);
            System.out.println("ch="+ch);
            System.out.println("f="+f);
            System.out.println("l="+l);
            System.out.println("result="+result);
        }

        /* Exercise 3-9. 다음은 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만 변수 b의 값이 true가 되도록 하는 코드이다.
         * (1)에 알맞은 코드를 넣으시오.
         */
        private static void Exercise9() {
            char ch = 'z';
            boolean b = ch>='a'&&ch<='z' || ch>='A'&&ch<='Z' || ch>='0'&&ch<='9'; //논리 연산자로 영대문자, 숫자의 경우 나열

            System.out.println(b);
        }

        /* Exercise 3-10. 다음은 대문자를 소문자로 변경하는 코드인데, 문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경한다.
         * 문자코드는 소문자가 대문자보다 32만큼 더 크다.
         * 예를 들어 'A'의 코드는 65이고, 'a'의 코드는 97이다.
         * (1)~(2)에 알맞은 코드를 넣으시오.
         */
        private static void Exercise10() {
            char ch = 'A';

            char lowerCase = ( ch>='A'&&ch<='Z') ? ( (char)(ch+32) ) : ch;  //3-9와 동일

            System.out.println("ch : " + ch);
            System.out.println("ch to lowerCase : " + lowerCase);
        }
    }

