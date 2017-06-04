package yonsei.xdesign.tochelin.models;

public class ModelSampler {
    public static Restaurant[] getRestaurants() {
        return new Restaurant[] {
                new Restaurant(
                        "restaurantId1",
                        "1. 키친's 별",
                        "신촌, 서대문구 - 126m",
                        "일식 레스토랑",
                        463,
                        new String[] {
                                "짜다", "비싸다"
                        },
                        "8.2",
                        "https://s-media-cache-ak0.pinimg.com/736x/47/05/e7/4705e78e484bd41ba317053174371399.jpg",
                        ModelSampler.getStats()),
                new Restaurant(
                        "restaurantId2",
                        "1. 키친's 별",
                        "신촌, 서대문구 - 126m",
                        "일식 레스토랑",
                        463,
                        new String[] {
                                "짜다", "비싸다"
                        },
                        "8.2",
                        "https://s-media-cache-ak0.pinimg.com/736x/47/05/e7/4705e78e484bd41ba317053174371399.jpg",
                        ModelSampler.getStats()),
                new Restaurant(
                        "restaurantId3",
                        "1. 키친's 별",
                        "신촌, 서대문구 - 126m",
                        "일식 레스토랑",
                        463,
                        new String[] {
                                "짜다", "비싸다"
                        },
                        "8.2",
                        "https://s-media-cache-ak0.pinimg.com/736x/47/05/e7/4705e78e484bd41ba317053174371399.jpg",
                        ModelSampler.getStats()),
        };
    }

    public static Stat[] getStats() {
        return new Stat[] {
                new Stat(
                        "맛",
                        4.1,
                        new String[] {
                                "짜다", "맛없다", "느끼하다", "노맛", "학식", "너무 달다",
                        },
                        ModelSampler.getReviews()),
                new Stat(
                        "위생",
                        3.1,
                        new String[] {
                                "짜다", "맛없다", "느끼하다", "노맛", "학식", "너무 달다",
                        },
                        ModelSampler.getReviews()),
                new Stat(
                        "대기시간",
                        4.5,
                        new String[] {
                                "짜다", "맛없다", "느끼하다", "노맛", "학식", "너무 달다",
                        },
                        ModelSampler.getReviews()),
                new Stat(
                        "서비스",
                        2,
                        new String[] {
                                "짜다", "맛없다", "느끼하다", "노맛", "학식", "너무 달다",
                        },
                        ModelSampler.getReviews()),
                new Stat(
                        "접근성",
                        0.2,
                        new String[] {
                                "짜다", "맛없다", "느끼하다", "노맛", "학식", "너무 달다",
                        },
                        ModelSampler.getReviews()),
                new Stat(
                        "가성비",
                        4.7,
                        new String[] {
                                "짜다", "맛없다", "느끼하다", "노맛", "학식", "너무 달다",
                        },
                        ModelSampler.getReviews()),
        };
    }

    public static Review[] getReviews() {
        return new Review[] {
                new Review(
                        "reviewId1",
                        "송하영",
                        "2017-01-26",
                        "친구들끼리 가서 파스터 하나씩(빠네 치킨파스타 연어로제) 주문했어요. 가격이 다른 파스타집보다 저렴하다고 생각했는데 확실히 양이 적고(이부분은 괜찮았어요) 재료와 맛이 부족한 것 같아요. 소스는 꼭 시탄소스처럼 자극적이고 달았어요. 그리고 무엇보다 피클이 없었어요 :(",
                        "https://s-media-cache-ak0.pinimg.com/736x/47/05/e7/4705e78e484bd41ba317053174371399.jpg",
                        new String[] {
                                "https://s-media-cache-ak0.pinimg.com/736x/47/05/e7/4705e78e484bd41ba317053174371399.jpg",
                                "https://s-media-cache-ak0.pinimg.com/736x/47/05/e7/4705e78e484bd41ba317053174371399.jpg",
                        }),
                new Review(
                        "reviewId2",
                        "초짜맨",
                        "2017-01-14",
                        "정말 역대급 최악의 식당. 비슷한 가격의 로스꼬꼬가 너무 그리워지네요.. 서비스 및 전부 최악입니다. 음식나오는 속도부터 보통 음식점보다 오래걸리구요, 그래서 나름 기다렸는데 무슨 급식에 나오는 급의 음식이 나오네요.. 게살크림파스타는 집에서 혼자 처음으로 까르보나라 만들었을때 그 맛보다 별로입니다. 걍 파마산치즈가루만 잔뜩 뿌리고 싸구려게 반조각? 올려놓은... 3천원정도면 먹을만 한 것 같습니다.",
                        "https://s-media-cache-ak0.pinimg.com/736x/47/05/e7/4705e78e484bd41ba317053174371399.jpg",
                        new String[] {
                                "https://s-media-cache-ak0.pinimg.com/736x/47/05/e7/4705e78e484bd41ba317053174371399.jpg",
                                "https://s-media-cache-ak0.pinimg.com/736x/47/05/e7/4705e78e484bd41ba317053174371399.jpg",
                        }),

        };
    }
}
