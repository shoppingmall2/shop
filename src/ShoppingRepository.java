public class ShoppingRepository {

    static SignUpUser user;
    private final MemberList membersList;
    SignUpUser members;
    MemberList memberList;
    MemberList restoreList;

    // 생성자
    ShoppingRepository() {

        // 객체 형식 빈 공간 만들어주고 시작 @@
        this.membersList = new MemberList();
        memberList.push(new SignUpUser("abc@def.com", "1234", "강지돌", "지도리", 20, "여성", "aaa@naver.com", "마포구"));
        memberList.push(new SignUpUser("ghi@def.com", "5432", "박수순", "수수니", 27,"여성", "bbb@naver.com", "서대문구"));
        memberList.push(new SignUpUser("xyz@def.com", "7890", "최태풍", "바람풍", 30, "남성", "ccc@naver.com", "종로구"));

        this.restoreList = new MemberList();
    }

    public SignUpUser getSignUpUser() {

        return user;
    }

    public boolean isDuplicateEmail(String targetEmail) {
        return members.findIndex(targetEmail) != -1;
    }
}
