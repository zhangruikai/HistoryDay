package com.baway.project.historyday.bean;

import java.util.List;

/**
 * Created by 张瑞凯 on 2017/3/30.
 */
public class DetailBean {
    /**
     * reason : success
     * result : [{"e_id":"3989","title":"印象画派巨匠梵高诞辰","content":"    在163年前的今天，1853年3月30日 (农历二月廿一)，印象画派巨匠梵高诞辰。\r\n    文森特·威廉·梵高出生在荷兰一个乡村牧师家庭。他是后印象派的三大巨匠之一。\r\n    梵高年轻时在画店里当店员，这算是他最早受的\u201c艺术教育\u201d。后来到巴黎，和印象派画家相交，在色彩方面受到启发和熏陶。以此，人们称他为\u201c后印象派\u201d。但比印象派画家更彻底地学习了东方艺术中线条的表现力，他很欣赏日本葛饰北斋的\u201c浮世绘\u201d。而在西方画家中，从精神上给他更大的影响的则是伦勃朗、杜米埃和米莱（Millet）。\r\n    梵高生性善良，早年为了\u201c抚慰世上一切不幸的人\u201d，他曾自费到一个矿区（博里纳日）里去当过教士，跟矿工一样吃最差的伙食，一起睡在地板上。矿坑爆炸时，他曾冒死救出一个重伤的矿工。然而在他主持的一次葬礼上，一位老人的厉声谴责使他突然变得清醒，他开始意识到这世界上根本就没有上帝，博里纳日的矿工们再也不需要上帝，当然也不需要他了。这样，他才又回到绘画事业上来，受到他的表兄以及当时荷兰一些画家短时间的指导，并与巴黎新起的画家（包括印象派画家）建立了友谊。\r\n    梵高全部杰出的、富有独创性的作品，都是在他生命最后的六年中完成的。他最初的作品，情调常是低沉的，可是后来，他大量的作品即一变低沉而为响亮和明朗，好象要用欢快的歌声来慰藉人世的苦难，以表达他强烈的理想和希望。一位英国评论家说：\u201c他用全部精力追求了一件世界上最简单、最普通的东西，这就是太阳。\u201d他的画面上不单充满了阳光下的鲜艳色彩，而且不止一次地下面去描绘令人逼视的太阳本身，并且多次描绘向日葵。为了纪念他去世的表兄莫夫，他画了一幅阳光下《盛开的桃花》，并题写诗句说：\u201c只要活人还活着，死去的人总还是活着。\u201d\r\n    在历史的角度来讲，梵高的确是非常超前的画家。他作品中所包含着深刻的悲剧意识,其强烈的个性和在形式上的独特追求,远远走在时代的前面,的确难以被当时的人们所接受。他以环境来抓住对象,他重新改变现实，以达到实实在在的真实，促成了表现主义的诞生。在人们对他的误解最深的时候，正是他对自己的创作最有信心的时候。因此才留下了永远的艺术著作。他直接影响了法国的野兽主义,德国的表现主义,以至于20世纪初出现的抒情抽象肖像。《向日葵》就是在阳光明媚灿烂的法国南部所作的。画家像闪烁着熊熊的火焰,满怀炽热的激情令运动感的和仿佛旋转不停的笔触是那样粗厚有力,色彩的对比也是单纯强烈的。然而,在这种粗厚和单纯中却又充满了智慧和灵气。观者在观看此画时,无不为那激动人心的画面效果而感动,心灵为之震颤,激情也喷薄而出,无不跃跃欲试,共同融入到梵高丰富的主观感情中去。总之,梵高笔下的向日葵不仅仅是植物,而是带有原始冲动和热情的生命体。\r\n    梵高的代表作有《吃土豆的人们》（1885）、《夜咖啡》（1888）、《向日葵》（1888）、《星夜》（1889）、《自画像》（1889）、《加歇医生》（1890）、《鸢尾花》（1890）等。\r\n\r\n","picNo":"5","picUrl":[{"pic_title":"梵高19岁时的照片","id":1,"url":"http://images.juheapi.com/history/3989_1.jpg"},{"pic_title":"爱过梵高的唯一的女人玛戈特贝曼","id":2,"url":"http://images.juheapi.com/history/3989_2.jpg"},{"pic_title":"戴高帽的凡高。这张照片发现于梵高逝世后100年，是已知的唯一的他成年后拍的照片。","id":3,"url":"http://images.juheapi.com/history/3989_3.jpg"},{"pic_title":"1886年梵高在塞纳河边的照片。背对镜头的是梵高。","id":4,"url":"http://images.juheapi.com/history/3989_4.jpg"},{"pic_title":"梵高诞辰（梵高在精神病院里住过的床）","id":5,"url":"http://images.juheapi.com/history/3989_5.jpg"}]}]
     * error_code : 0
     */
    private String reason;
    private int error_code;
    private List<ResultBean> result;
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * e_id : 3989
         * title : 印象画派巨匠梵高诞辰
         * content :     在163年前的今天，1853年3月30日 (农历二月廿一)，印象画派巨匠梵高诞辰。
             文森特·威廉·梵高出生在荷兰一个乡村牧师家庭。他是后印象派的三大巨匠之一。
             梵高年轻时在画店里当店员，这算是他最早受的“艺术教育”。后来到巴黎，和印象派画家相交，在色彩方面受到启发和熏陶。以此，人们称他为“后印象派”。但比印象派画家更彻底地学习了东方艺术中线条的表现力，他很欣赏日本葛饰北斋的“浮世绘”。而在西方画家中，从精神上给他更大的影响的则是伦勃朗、杜米埃和米莱（Millet）。
             梵高生性善良，早年为了“抚慰世上一切不幸的人”，他曾自费到一个矿区（博里纳日）里去当过教士，跟矿工一样吃最差的伙食，一起睡在地板上。矿坑爆炸时，他曾冒死救出一个重伤的矿工。然而在他主持的一次葬礼上，一位老人的厉声谴责使他突然变得清醒，他开始意识到这世界上根本就没有上帝，博里纳日的矿工们再也不需要上帝，当然也不需要他了。这样，他才又回到绘画事业上来，受到他的表兄以及当时荷兰一些画家短时间的指导，并与巴黎新起的画家（包括印象派画家）建立了友谊。
             梵高全部杰出的、富有独创性的作品，都是在他生命最后的六年中完成的。他最初的作品，情调常是低沉的，可是后来，他大量的作品即一变低沉而为响亮和明朗，好象要用欢快的歌声来慰藉人世的苦难，以表达他强烈的理想和希望。一位英国评论家说：“他用全部精力追求了一件世界上最简单、最普通的东西，这就是太阳。”他的画面上不单充满了阳光下的鲜艳色彩，而且不止一次地下面去描绘令人逼视的太阳本身，并且多次描绘向日葵。为了纪念他去世的表兄莫夫，他画了一幅阳光下《盛开的桃花》，并题写诗句说：“只要活人还活着，死去的人总还是活着。”
             在历史的角度来讲，梵高的确是非常超前的画家。他作品中所包含着深刻的悲剧意识,其强烈的个性和在形式上的独特追求,远远走在时代的前面,的确难以被当时的人们所接受。他以环境来抓住对象,他重新改变现实，以达到实实在在的真实，促成了表现主义的诞生。在人们对他的误解最深的时候，正是他对自己的创作最有信心的时候。因此才留下了永远的艺术著作。他直接影响了法国的野兽主义,德国的表现主义,以至于20世纪初出现的抒情抽象肖像。《向日葵》就是在阳光明媚灿烂的法国南部所作的。画家像闪烁着熊熊的火焰,满怀炽热的激情令运动感的和仿佛旋转不停的笔触是那样粗厚有力,色彩的对比也是单纯强烈的。然而,在这种粗厚和单纯中却又充满了智慧和灵气。观者在观看此画时,无不为那激动人心的画面效果而感动,心灵为之震颤,激情也喷薄而出,无不跃跃欲试,共同融入到梵高丰富的主观感情中去。总之,梵高笔下的向日葵不仅仅是植物,而是带有原始冲动和热情的生命体。
             梵高的代表作有《吃土豆的人们》（1885）、《夜咖啡》（1888）、《向日葵》（1888）、《星夜》（1889）、《自画像》（1889）、《加歇医生》（1890）、《鸢尾花》（1890）等。


         * picNo : 5
         * picUrl : [{"pic_title":"梵高19岁时的照片","id":1,"url":"http://images.juheapi.com/history/3989_1.jpg"},{"pic_title":"爱过梵高的唯一的女人玛戈特贝曼","id":2,"url":"http://images.juheapi.com/history/3989_2.jpg"},{"pic_title":"戴高帽的凡高。这张照片发现于梵高逝世后100年，是已知的唯一的他成年后拍的照片。","id":3,"url":"http://images.juheapi.com/history/3989_3.jpg"},{"pic_title":"1886年梵高在塞纳河边的照片。背对镜头的是梵高。","id":4,"url":"http://images.juheapi.com/history/3989_4.jpg"},{"pic_title":"梵高诞辰（梵高在精神病院里住过的床）","id":5,"url":"http://images.juheapi.com/history/3989_5.jpg"}]
         */

        private String e_id;
        private String title;
        private String content;
        private String picNo;
        private List<PicUrlBean> picUrl;

        public String getE_id() {
            return e_id;
        }

        public void setE_id(String e_id) {
            this.e_id = e_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPicNo() {
            return picNo;
        }

        public void setPicNo(String picNo) {
            this.picNo = picNo;
        }

        public List<PicUrlBean> getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(List<PicUrlBean> picUrl) {
            this.picUrl = picUrl;
        }

        public static class PicUrlBean {
            /**
             * pic_title : 梵高19岁时的照片
             * id : 1
             * url : http://images.juheapi.com/history/3989_1.jpg
             */

            private String pic_title;
            private int id;
            private String url;

            public String getPic_title() {
                return pic_title;
            }

            public void setPic_title(String pic_title) {
                this.pic_title = pic_title;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
