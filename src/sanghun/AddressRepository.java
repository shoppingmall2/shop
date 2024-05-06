package sanghun;

import user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static user.UserRepository.loggedInUser;

public class AddressRepository {
        public static Address defaultAddress;


    private static final List<String> CITIES = Arrays.asList( // 도시
            "서울특별시", "대구광역시", "전라남도"
    );
    private static final List<String> seoulDistricts = Arrays.asList( // 시군구
            "종로구", "중구", "용산구", "성동구", "광진구",
            "동대문구", "중랑구", "성북구", "강북구", "도봉구",
            "노원구", "은평구", "서대문구", "마포구", "양천구",
            "강서구", "구로구", "금천구", "영등포구", "동작구",
            "관악구", "서초구", "강남구", "송파구", "강동구"
    );


    List<String> yeongdeungpoDongs = Arrays.asList( // 영등포
            "대림동", "여의도동", "문래동", "양평동", "당산동",
            "도림동", "영등포동", "신길동", "대방동", "신길1동",
            "신길2동", "신길3동", "신길4동", "신길5동", "신길6동"
    );
    List<String> jongnoDongs = Arrays.asList( // 종로구
            "청운효자동", "사직동", "삼청동", "부암동", "평창동",
            "무악동", "교남동", "가회동", "종로1.2.3.4가동", "종로5.6가동",
            "이화동", "혜화동", "창신제1동", "창신제2동", "창신제3동",
            "숭인제1동", "숭인제2동"
    );
    List<String> jungguDongs = Arrays.asList( // 중구
            "소공동", "회현동", "명동", "필동", "장충동",
            "광희동", "을지로동", "신당동", "다산동", "약수동",
            "청구동", "신당제5동", "동화동", "황학동", "중림동"
    );
    List<String> yongsanDongs = Arrays.asList( // 용산구
            "후암동", "용산동2가", "남영동", "청파동1가", "청파동2가",
            "청파동3가", "원효로1가", "원효로2가", "효창동", "용문동",
            "한강로1가", "한강로2가", "한강로3가", "이촌동", "이태원동",
            "한남동", "서빙고동", "보광동"
    );
    List<String> seongdongDongs = Arrays.asList( // 성동구
            "왕십리도선동", "왕십리2동", "마장동", "사근동", "행당1동",
            "행당2동", "응봉동", "금호1가동", "금호2.3가동", "금호4가동",
            "옥수동", "성수1가1동", "성수1가2동", "성수2가1동", "성수2가3동",
            "송정동", "용답동", "화양동", "군자동"
    );
    List<String> gwangjinDongs = Arrays.asList( // 광진구
            "화양동", "군자동", "중곡1동", "중곡2동", "중곡3동",
            "중곡4동", "능동", "광장동", "자양1동", "자양2동",
            "자양3동", "자양4동", "구의1동", "구의2동", "구의3동"
    );
    List<String> dongdaemunDongs = Arrays.asList( //동대문구
            "청량리동", "회기동", "용신동", "전농1동", "전농2동",
            "답십리1동", "답십리2동", "장안1동", "장안2동", "청량리동",
            "이문1동", "이문2동", "제기동", "전농동", "답십리동",
            "장안동", "이문동", "휘경1동"
    );
    List<String> jungnangDongs = Arrays.asList( //중랑구
            "면목본동", "면목2동", "면목3.8동", "면목4동", "면목5동",
            "면목7동", "면목본동", "면목동", "묵1동", "묵2동",
            "묵동", "상봉1동", "상봉2동", "신내1동", "신내2동",
            "중화1동", "중화2동"
    );
    List<String> seongbukDongs = Arrays.asList( //성복구우
            "길음1동", "길음2동", "종암동", "하월곡동", "상월곡동",
            "장위1동", "장위2동", "장위3동", "석관동", "삼선동",
            "동선동", "성북동", "안암동", "보문동", "정릉1동",
            "정릉2동", "정릉3동", "정릉4동", "길음동", "돈암1동",
            "돈암2동", "안암동", "보문동", "보문동", "보문동",
            "정릉동", "정릉동", "정릉동", "정릉동", "길음동",
            "동소문동", "동소문동", "동소문동", "동소문동", "동소문동"
    );
    List<String> gangbukDongs = Arrays.asList( // 강북구의 동네
            "번1동", "번2동", "번3동", "수유1동", "수유2동",
            "수유3동", "삼양동", "미아동", "송중동", "송천동",
            "삼각산동", "우이동", "인수동", "성북동", "삼청동",
            "북아현동", "보문동", "삼선동", "삼선동", "창신1동",
            "창신2동", "창신3동", "숭인1동", "숭인2동", "월계1동",
            "월계2동", "월계3동", "공릉1동", "공릉2동", "하월곡동",
            "상월곡동", "장위1동", "장위2동", "장위3동", "석관동",
            "삼양동", "미아동", "송중동", "송천동", "삼각산동",
            "우이동", "인수동", "창신동", "창신동", "숭인동",
            "숭인동", "월계동", "공릉동", "하월곡동", "상월곡동",
            "장위동", "석관동"
    );
    List<String> dobongDongs = Arrays.asList( //도봉구
            "창동", "도봉동", "방학동", "쌍문1동", "쌍문2동",
            "쌍문3동", "쌍문4동", "방학1동", "방학2동", "방학3동"
    );
    List<String> nowonDongs = Arrays.asList( //노원구
            "상계동", "월계1동", "월계2동", "월계3동", "공릉1동",
            "공릉2동", "하계1동", "하계2동", "중계본동", "중계1동",
            "중계4동", "중계2.3동", "상계2동", "상계3.4동", "상계5동",
            "상계6.7동", "상계8동", "상계9동", "상계10동"
    );
    List<String> eunpyeongDongs = Arrays.asList( // 은평구
            "녹번동", "불광1동", "불광2동", "갈현1동", "갈현2동",
            "구산동", "대조동", "응암1동", "응암2동", "응암3동",
            "역촌동", "신사1동", "신사2동", "증산동", "수색동"
    );
    List<String> seodaemunDongs = Arrays.asList( //서대문구
            "천연동", "북아현동", "충현동", "신촌동", "연희동",
            "홍제1동", "홍제2동", "홍제3동", "홍은1동", "홍은2동",
            "남가좌1동", "남가좌2동", "북가좌1동", "북가좌2동", "아현동",
            "공덕동", "신공덕동"
    );
    List<String> mapoDongs = Arrays.asList( //마포구의 동네
            "아현동", "공덕동", "신공덕동", "도화동", "용강동",
            "대흥동", "염리동", "신수동", "서강동", "서교동",
            "합정동", "망원1동", "망원2동", "연남동", "성산1동",
            "성산2동", "상암동"
    );
    List<String> yangcheonDongs = Arrays.asList( //양천구
            "신정1동", "신정2동", "신정3동", "신정4동", "신정6동",
            "신정7동", "목1동", "목2동", "목3동", "목4동",
            "목5동", "신월1동", "신월2동", "신월3동", "신월4동",
            "신월5동", "신월6동", "신월7동", "신정동"
    );
    List<String> gangseoDongs = Arrays.asList( // 강서구
            "염창동", "등촌1동", "등촌2동", "등촌3동", "화곡1동",
            "화곡2동", "화곡3동", "화곡4동", "화곡6동", "화곡8동",
            "가양1동", "가양2동", "가양3동", "발산1동", "공항동",
            "방화1동", "방화2동", "방화3동", "신도림동"
    );
    List<String> guroDongs = Arrays.asList( // 구로구
            "신도림동", "구로1동", "구로2동", "구로3동", "구로4동",
            "구로5동", "고척1동", "고척2동", "개봉1동", "개봉2동",
            "개봉3동", "오류1동", "오류2동", "수궁동", "가리봉동"
    );
    List<String> geumcheonDongs = Arrays.asList( // 금천구
            "가산동", "독산1동", "독산2동", "독산3동", "독산4동",
            "시흥1동", "시흥2동", "시흥3동", "시흥4동"
    );
    List<String> dongjakDongs = Arrays.asList( //동작구
            "노량진1동", "노량진2동", "상도1동", "상도2동", "상도3동",
            "상도4동", "흑석동", "사당1동", "사당2동", "사당3동",
            "사당4동", "사당5동", "대방동", "신대방1동", "신대방2동"
    );
    List<String> gwanakDongs = Arrays.asList( // 관악구
            "신림동", "남현동", "청룡동", "서림동", "신사동",
            "신원동", "은천동", "낙성대동", "삼성동", "미성동",
            "보라매동", "성현동", "인헌동", "난곡동", "조원동",
            "대학동", "삼전동", "보라매본동", "신원동", "서원동",
            "신림동", "난향동", "조원동", "난곡동", "신원동",
            "난곡동", "신림동", "서원동", "보라매동", "서림동"
    );

    List<String> seochoDongs = Arrays.asList( // 서초구
            "서초동", "반포동", "잠원동", "양재동", "내곡동",
            "염곡동", "신원동", "양재동", "우면동", "원지동",
            "서초동", "반포동", "잠원동", "양재동", "내곡동",
            "염곡동", "신원동", "양재동", "우면동", "원지동"
    );

    List<String> gangnamDongs = Arrays.asList( //강남구
            "개포동", "논현동", "대치동", "도곡동", "삼성동",
            "세곡동", "수서동", "신사동", "압구정동", "역삼동",
            "율현동", "일원동", "자곡동", "청담동", "삼성1동",
            "삼성2동", "삼성3동", "압구정동", "역삼동", "율현동",
            "일원동", "일원본동", "청담동", "대치1동", "대치2동",
            "대치4동", "도곡1동", "도곡2동", "도곡본동", "삼성1동",
            "삼성2동", "삼성3동", "압구정동", "역삼동", "율현동",
            "일원동", "일원본동", "청담동"
    );
    List<String> songpaDongs = Arrays.asList( //송파구
            "가락동", "거여동", "마천동", "문정동", "방이동",
            "석촌동", "송파동", "신천동", "오금동", "잠실동",
            "가락본동", "가락1동", "가락2동", "가락3동", "가락4동",
            "거여1동", "거여2동", "마천1동", "마천2동", "문정1동",
            "문정2동", "잠실본동", "잠실2동", "잠실3동", "잠실4동",
            "잠실6동", "잠실7동", "잠실새내동", "장지동", "풍납1동",
            "풍납2동"
    );

    List<String> gangdongDongs = Arrays.asList( // 강동구
            "강일동", "고덕동", "길동", "둔촌동", "명일동",
            "상일동", "성내동", "암사동", "천호동"
    );


    public static void addUser(Address address) {
        addressList.add(address);
    }

    public static final List<Address> addressList = new ArrayList<>();

    static {
        addressList.add(new Address("서울특별시", "영등포구", "대림동",
                "1075-44 201호"));
    }


    public boolean stateCheck(String state) {
        return CITIES.contains(state);
    }


    public boolean cityCheck(String districts) {
        return seoulDistricts.contains(districts);
    }


    public String[] stateSout() {
        return CITIES.toArray(new String[0]);
    }


    public String[] addressOut() {
        return seoulDistricts.toArray(new String[0]);
    }

    public boolean isValidDistrict(String district) {
        return seoulDistricts.contains(district) || jongnoDongs.contains(district) || jungguDongs.contains(district)
                || yongsanDongs.contains(district) || seongdongDongs.contains(district) || gwangjinDongs.contains(district)
                || dongdaemunDongs.contains(district) || jungnangDongs.contains(district) || seongbukDongs.contains(district)
                || gangbukDongs.contains(district) || dobongDongs.contains(district) || nowonDongs.contains(district)
                || eunpyeongDongs.contains(district) || seodaemunDongs.contains(district) || mapoDongs.contains(district)
                || yangcheonDongs.contains(district) || gangseoDongs.contains(district) || guroDongs.contains(district)
                || geumcheonDongs.contains(district) || dongjakDongs.contains(district) || gwanakDongs.contains(district)
                || seochoDongs.contains(district) || gangnamDongs.contains(district) || songpaDongs.contains(district)
                || gangdongDongs.contains(district) || yeongdeungpoDongs.contains(district);
    }


    public boolean defaultAddressSet(String num) {
        switch (num) {
            case "1" :
                defaultAddress = loggedInUser.getAddress().get(0);
                return true;
            case "2":
                if (loggedInUser.getAddress().size() > 1) {
                    defaultAddress = loggedInUser.getAddress().get(1);
                    return true;
                } else {
                    return false;
                }
            case "3":
                if (loggedInUser.getAddress().size() > 2) {
                    defaultAddress = loggedInUser.getAddress().get(2);
                    return true;
                }else {
                    return false;
                }
        }
        return false;
    }

    public Address defaultAddress() {
        return defaultAddress;
    }
}
