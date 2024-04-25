public class MemberList {

    SignUpUser[] mArr;

    MemberList() {
        this.mArr = new SignUpUser[0];
    }

    // 맨 끝에 추가
    void push(SignUpUser newMember) {
        SignUpUser[] temp = new SignUpUser[mArr.length + 1];
        for (int i = 0; i < mArr.length; i++) {
            temp[i] = mArr[i];
        }
        temp[temp.length - 1] = newMember;
        mArr = temp;
    }
    // 인덱스 찾기
    int findIndex(String email) {
        for (int i = 0; i < mArr.length; i++) {
            if (email.equals(mArr[i].getEmail())) {
                return i;
            }
        }
        return -1;
    }
    // 한 명의 회원 정보 얻기
    SignUpUser get(String email) {
        int index = findIndex(email);
        if (index == -1) return null; // -1 null로 처리해서 안전하게 !
        return get(index);
    }
    SignUpUser get(int index) {
        return mArr[index];
    }

    // 맨 끝 제거
    SignUpUser pop() {
        // 맨 끝 회원 백업
        SignUpUser lastMember = mArr[mArr.length - 1];
        SignUpUser[] temp = new SignUpUser[mArr.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = mArr[i];
        }
        mArr = temp;
        return lastMember;
    }

    // 회원 정보 삭제
    SignUpUser remove(int index) {
        // 삭제 대상 백업 - 삭제 전 대상 꺼내놓기 !
        SignUpUser removedMember = mArr[index];
        for (int i = index; i < mArr.length - 1; i++) {
            mArr[i] = mArr[i + 1];
        }
        pop();
        return removedMember;
    }
    SignUpUser remove(SignUpUser deleteMember) {
        int index = findIndex(deleteMember.getEmail());
        return remove(index);
    }

    // 배열에 저장된 요소 수 리턴
    int size() {
        return mArr.length;
    }

    // 배열 리턴
    SignUpUser[] getMembers() {
        return mArr;
    }

}
