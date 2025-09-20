public class Event {
    private String time; // время
    private String title; // чего делаем
    private String comm; // комментарий

    //конструктор
    public Event(String time, String title, String comm) {
        this.time = time;
        this.title = title;
        this.comm = comm;
    }
    //получение данных для вывода расписания, мб потом в одно объединим, хз пока
    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getComm() {
        return comm;
    }
    //редактирование, тоже не знаю успеем ли, но пусть будет, потом в самого бота засунем
    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComm(String comm) {
        this.comm = this.comm;
    }

    //объединила в одно, то пока оставим, пусть будет
    public String massage() {
        return time + " - " + title + " (" + comm + ")";
    }

}
