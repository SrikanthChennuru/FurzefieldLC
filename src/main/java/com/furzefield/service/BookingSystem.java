package com.furzefield.service;

import com.furzefield.model.Booking;
import com.furzefield.model.Lesson;
import com.furzefield.model.Member;
import com.furzefield.model.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem
{
    private List<Member> members;
    private List<Lesson> lessons;
    private List<Booking> bookings;
    private int bookingCounter;

    public BookingSystem()
    {
        this.members = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.bookingCounter = 1;
    }

    public void initialiseTimetable()
    {
        // prices per exercise
        // Yoga=£12 Zumba=£10, Aquacise=£8, BoxFit=£15, BodyBlitz=£11

        // Week 1 - Saturday (Month 1)
        lessons.add(new Lesson("L001", "Yoga",      "Saturday", 1, 1, TimeSlot.MORNING, 12.00));
        lessons.add(new Lesson("L002", "Zumba",     "Saturday", 1, 1, TimeSlot.AFTERNOON, 10.00));
        lessons.add(new Lesson("L003", "Aquacise",  "Saturday", 1, 1, TimeSlot.EVENING, 08.00));
        // Week 1 - Sunday (Month 1)
        lessons.add(new Lesson("L004", "BoxFit",        "Sunday", 1, 1, TimeSlot.MORNING, 15.00));
        lessons.add(new Lesson("L005", "BodyBlitz",     "Sunday", 1, 1, TimeSlot.AFTERNOON, 11.00));
        lessons.add(new Lesson("L006", "Yoga",          "Sunday", 1, 1, TimeSlot.EVENING, 12.00));

        // Week 2 - Saturday (Month 1)
        lessons.add(new Lesson("L007", "Zumba",      "Saturday", 2, 1, TimeSlot.MORNING, 10.00));
        lessons.add(new Lesson("L008", "Boxfit",     "Saturday", 2, 1, TimeSlot.AFTERNOON, 15.00));
        lessons.add(new Lesson("L009", "BodyBlitz",  "Saturday", 2, 1, TimeSlot.EVENING, 11.00));
        // Week 2 - Sunday (Month 1)
        lessons.add(new Lesson("L0010", "Aquacise",    "Sunday", 2, 1, TimeSlot.MORNING, 08.00));
        lessons.add(new Lesson("L0011", "Yoga",        "Sunday", 2, 1, TimeSlot.AFTERNOON, 12.00));
        lessons.add(new Lesson("L0012", "Zumba",       "Sunday", 2, 1, TimeSlot.EVENING, 10.00));

        // Week 3 - Saturday (Month 1)
        lessons.add(new Lesson("L0013", "BoxFit",    "Saturday", 3, 1, TimeSlot.MORNING, 15.00));
        lessons.add(new Lesson("L0014", "Aquacise",  "Saturday", 3, 1, TimeSlot.AFTERNOON, 08.00));
        lessons.add(new Lesson("L0015", "Yoga",      "Saturday", 3, 1, TimeSlot.EVENING, 12.00));
        // Week 3 - Sunday (Month 1)
        lessons.add(new Lesson("L0016", "BodyBlitz", "Sunday", 3, 1, TimeSlot.MORNING, 11.00));
        lessons.add(new Lesson("L0017", "Zumba",     "Sunday", 3, 1, TimeSlot.AFTERNOON, 10.00));
        lessons.add(new Lesson("L0018", "BoxFit",    "Sunday", 3, 1, TimeSlot.EVENING, 15.00));

        // Week 4 - Saturday (Month 1)
        lessons.add(new Lesson("L0019", "Yoga",      "Saturday", 4, 1, TimeSlot.MORNING, 12.00));
        lessons.add(new Lesson("L0020", "BodyBlitz", "Saturday", 4, 1, TimeSlot.AFTERNOON, 11.00));
        lessons.add(new Lesson("L0021", "Zumba",     "Saturday", 4, 1, TimeSlot.EVENING, 10.00));
        // Week 4 - Sunday (Month 1)
        lessons.add(new Lesson("L0022", "Aquacise",    "Sunday", 4, 1, TimeSlot.MORNING, 08.00));
        lessons.add(new Lesson("L0023", "BoxFit",      "Sunday", 4, 1, TimeSlot.AFTERNOON, 15.00));
        lessons.add(new Lesson("L0024", "BodyBlitz",   "Sunday", 4, 1, TimeSlot.EVENING, 11.00));

        // Week 5 - Saturday (Month 2)
        lessons.add(new Lesson("L0025", "Aquacise", "Saturday", 5, 2, TimeSlot.MORNING, 08.00));
        lessons.add(new Lesson("L0026", "Yoga",     "Saturday", 5, 2, TimeSlot.AFTERNOON, 12.00));
        lessons.add(new Lesson("L0027", "BoxFit",   "Saturday", 5, 2, TimeSlot.EVENING, 15.00));
        // Week 5 - Sunday (Month 2)
        lessons.add(new Lesson("L0028", "Zumba",        "Sunday", 5, 2, TimeSlot.MORNING, 10.00));
        lessons.add(new Lesson("L0029", "BodyBlitz",    "Sunday", 5, 2, TimeSlot.AFTERNOON, 11.00));
        lessons.add(new Lesson("L0030", "Aquacise",     "Sunday", 5, 2, TimeSlot.EVENING, 08.00));

        // Week 6 - Saturday (Month 2)
        lessons.add(new Lesson("L0031", "BodyBlitz", "Saturday", 6, 2, TimeSlot.MORNING, 11.00));
        lessons.add(new Lesson("L0032", "Zumba",     "Saturday", 6, 2, TimeSlot.AFTERNOON, 10.00));
        lessons.add(new Lesson("L0033", "Yoga",      "Saturday", 6, 2, TimeSlot.EVENING, 12.00));
        // Week 6 - Sunday (Month 2)
        lessons.add(new Lesson("L0034", "BoxFit",    "Sunday", 6, 2, TimeSlot.MORNING, 15.00));
        lessons.add(new Lesson("L0035", "Aquacise",  "Sunday", 6, 2, TimeSlot.AFTERNOON, 08.00));
        lessons.add(new Lesson("L0036", "BodyBlitz", "Sunday", 6, 2, TimeSlot.EVENING, 11.00));

        // Week 7 - Saturday (Month 2)
        lessons.add(new Lesson("L0037", "Zumba",   "Saturday", 7, 2, TimeSlot.MORNING, 10.00));
        lessons.add(new Lesson("L0038", "BoxFit",  "Saturday", 7, 2, TimeSlot.AFTERNOON, 15.00));
        lessons.add(new Lesson("L0039", "Aquacise","Saturday", 7, 2, TimeSlot.EVENING, 08.00));
        // Week 7 - Sunday (Month 2)
        lessons.add(new Lesson("L0040", "Yoga",      "Sunday", 7, 2, TimeSlot.MORNING, 12.00));
        lessons.add(new Lesson("L0041", "Zumba",     "Sunday", 7, 2, TimeSlot.AFTERNOON, 10.00));
        lessons.add(new Lesson("L0042", "BodyBlitz", "Sunday", 7, 2, TimeSlot.EVENING, 11.00));

        // Week 8 - Saturday (Month 2)
        lessons.add(new Lesson("L0043", "BoxFit",    "Saturday", 8, 2, TimeSlot.MORNING, 15.00));
        lessons.add(new Lesson("L0044", "Yoga",      "Saturday", 8, 2, TimeSlot.AFTERNOON, 12.00));
        lessons.add(new Lesson("L0045", "BodyBlitz", "Saturday", 8, 2, TimeSlot.EVENING, 11.00));
        // Week 8 - Sunday (Month 2)
        lessons.add(new Lesson("L0046", "Zumba",    "Sunday", 8, 2, TimeSlot.MORNING, 10.00));
        lessons.add(new Lesson("L0047", "Aquacise", "Sunday", 8, 2, TimeSlot.AFTERNOON, 08.00));
        lessons.add(new Lesson("L0048", "Yoga",     "Sunday", 8, 2, TimeSlot.EVENING, 12.00));


    }

    public void initialiseMembers()
    {
        members.add(new Member("M001", "Alice Johnson", "alice@email.com"));
        members.add(new Member("M002", "Bob Smith",     "bob@email.com"));
        members.add(new Member("M003", "Carol White",   "carol@email.com"));
        members.add(new Member("M004", "David Brown",   "david@email.com"));
        members.add(new Member("M005", "Emma Davis",    "emma@email.com"));
        members.add(new Member("M006", "Frank Wilson",  "frank@email.com"));
        members.add(new Member("M007", "Grace Taylor",  "grace@email.com"));
        members.add(new Member("M008", "Harry Moor",    "harry@email.com"));
        members.add(new Member("M009", "Isla Martin",   "isla@email.com"));
        members.add(new Member("M010", "Jack Thompson", "jack@email.com"));


    }

    private String generateBookingId()
    {
        return "B" + String.format("%03d",bookingCounter++);
    }

    public boolean bookLesson(String memberId, String lessonId)
    {
        return false;
    }

    public boolean changeBooking(String bookingId, String newLessonId)
    {
        return false;
    }

    public boolean cancelBooking(String bookingId)
    {
        return false;
    }

    public boolean attendLesson(String bookingId, String review, int rating)
    {
        return false;
    }

    public List<Lesson> getLessonsByDay(String day)
    {
        return new ArrayList<>();
    }

    public List<Lesson> getLessonsByExerciseType(String exerciseType)
    {
        return new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public Member findMemberById(String memberId){
        return members.stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findFirst().orElse(null);
    }

    public Lesson findLessonById(String lessonId){
        return lessons.stream()
                .filter(l -> l.getLessonId().equals(lessonId))
                .findFirst().orElse(null);
    }

    public Booking findBookingById(String bookingId){
        return bookings.stream()
                .filter(b -> b.getBookingId().equals(bookingId))
                .findFirst().orElse(null);
    }
}
