package dto;
//dto클래스
//영화번호, 영화 이름, 영화 길이
//dto는 필드와 게터세터는 꼭들어간다
//toString은 들어가면 매우 좋고 안들어가도 된다.
public class MovieDTO {
	private int id;
	private String title;
	private int length;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "Movie [영화번호: " + id + "번, 영화제목:" + title + ", 상영시간: " + length + "분]";
	}
	
	public boolean equals(Object o) {
		if(o instanceof MovieDTO) {
			MovieDTO m = (MovieDTO) o;
			if(this.id == m.id) {
				return true;
			}
		}
			return false;
		
	}
		
}
