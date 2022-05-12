<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="default/myNavBar.jsp"></jsp:include>
<h1>首頁</h1>
<a><button>聯絡客服</button></a>
<a><button>關於我們</button></a>
<a><button>住宿</button></a>
<hr>
<p>地區選擇</p>
<a href="selectHotelByRegion?region=花蓮"><button>花蓮</button></a>
<a href="selectHotelByRegion?region=宜蘭"><button>宜蘭</button></a>
<a href="selectHotelByRegion?region=苗栗"><button>苗栗</button></a>
<a href="selectHotelByRegion?region=金門"><button>金門</button></a>
<a href="selectHotelByRegion?region=南投"><button>南投</button></a>
<a href="selectHotelByRegion?region=屏東"><button>屏東</button></a>
<a href="selectHotelByRegion?region=桃園"><button>桃園</button></a>
<a href="selectHotelByRegion?region=高雄"><button>高雄</button></a>
<a href="selectHotelByRegion?region=連江"><button>連江</button></a>
<a href="selectHotelByRegion?region=基隆"><button>基隆</button></a>
<a href="selectHotelByRegion?region=雲林"><button>雲林</button></a>
<a href="selectHotelByRegion?region=新北"><button>新北</button></a>
<a href="selectHotelByRegion?region=新竹"><button>新竹</button></a>
<a href="selectHotelByRegion?region=嘉義"><button>嘉義</button></a>
<a href="selectHotelByRegion?region=彰化"><button>彰化</button></a>
<a href="selectHotelByRegion?region=臺中"><button>臺中</button></a>
<a href="selectHotelByRegion?region=臺北"><button>臺北</button></a>
<a href="selectHotelByRegion?region=臺東"><button>臺東</button></a>
<a href="selectHotelByRegion?region=臺南"><button>臺南</button></a>
<a href="selectHotelByRegion?region=澎湖"><button>澎湖</button></a>
<hr>
<form action="">
	<div><input type="text" name="keyword" placeholder="你要去哪裡?"/></div>
	<div>入住日期:<input type="date" name="loginDate"/></div>
	<div>退房日期:<input type="date" name="logoutDate"/></div>
	<div>
		人數:<input type="number" min="0" max="10" step="1"/>人
	</div>
</form>
<hr>