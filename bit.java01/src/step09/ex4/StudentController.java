package step09.ex4;

import java.util.Scanner;

public class StudentController {
  static Student[] students = new Student[100];
  static int length = 0;
  static Scanner keyScan;

  static void doList() {
    for (int i = 0; i < length; i++) {
      Student student = students[i];
      System.out.printf("%s,%s,%s,%s,%s,%s,%d,%s\n",
        student.userId,
        student.password,
        student.name,
        student.tel,
        student.email,
        ((student.working)?"yes":"no"),
        student.birthYear,
        student.school);
    }
  }

  static void doAdd() {
    // 반복 해서 입력 받는다.
    while (length < students.length) {
      Student student = new Student();
      System.out.print("아이디(:hong)? ");
      student.userId = keyScan.nextLine();

      System.out.print("암호(예:1111)? ");
      student.password = keyScan.nextLine();

      System.out.print("이름(예:홍길동)? ");
      student.name = keyScan.nextLine();

      System.out.print("전화(예:010-1111-2222)? ");
      student.tel = keyScan.nextLine();

      System.out.print("이메일(예:hong@test.com)? ");
      student.email = keyScan.nextLine();

      System.out.print("재직중(y/n)? ");
      student.working = (keyScan.nextLine().equals("y")) ? true : false;

      System.out.print("태어난해(예:1980)? ");
      student.birthYear = Integer.parseInt(keyScan.nextLine());

      System.out.print("최종학교(예:비트고등학교)? ");
      student.school = keyScan.nextLine();

      students[length++] = student;

      System.out.print("계속 입력하시겠습니까(y/n)? ");
      if (!keyScan.nextLine().equals("y"))
        break;
    }
  }

  static void doView() {
    System.out.print("조회할 학생의 아이디는? ");
    String userId = keyScan.nextLine().toLowerCase();
    for (int i = 0; i < length; i++) {
      if (students[i].userId.toLowerCase().equals(userId)) {
        System.out.printf("아이디: %s\n", students[i].userId);
        System.out.printf("암호: (***)\n");
        System.out.printf("이름: %s\n", students[i].name);
        System.out.printf("전화: %s\n", students[i].tel);
        System.out.printf("이메일: %s\n", students[i].email);
        System.out.printf("재직중: %s\n", (students[i].working) ? "Yes" : "No");
        System.out.printf("태어난 해: %d\n", students[i].birthYear);
        System.out.printf("학교: %s\n", students[i].school);
        break;
      }
    }
  }
}
