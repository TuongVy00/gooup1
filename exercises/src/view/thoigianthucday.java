package view;

import java.time.Duration;
import java.time.LocalTime;

import static utils.InputUtils.*;

/**
 * Bạn nên thức dậy vào lúc mấy giờ sau mỗi đêm?
   Đối tượng => Độ tuổi (tuổi) => Thời gian ngủ tối thiểu (giờ/ngày)
   Trẻ mới sinh => 1 - 3 => 20
   Trẻ nhỏ => 4 - 13 => 10 - 12
   Thanh thiếu niên => 14 - 17 => 8 - 10
   Thanh niên và người trưởng thành => 18 - 64 => 7 - 9
   Người lớn tuổi => 65 => 7 - 8

   Viết chương trình mô phỏng bài toán như sau
	B1. Nhập tuổi hiện tại của bạn
	B2. Nhập thời gian đã ngủ trong ngày (giờ-phút)
	B3. Nhập thời gian bắt đầu ngủ
	B4. In ra thời gian bạn nên thức dậy để có một sức khỏe tốt
	Example:
	Tuổi: 22
	Thời gian đã ngủ
	+ Số giờ : 1
	+ Số phút: 15
	--> Thời gian bắt đầu ngủ: 23H
	--> Bạn nên thức dậy lúc: 5H45
	
	Giải thích
	==========================
	Tuổi 22 => Cần ngủ 7-9H / ngày => Trung bình: 8H = (7+9) 2
	Đã ngủ: 1H15P
	Còn lại: 8H - 1H15P = 6H45P
	Đi ngủ: 23H
	=> Bạn nên thức dậy: 23H + 6H45 = 5H45 sáng
 */

public class thoigianthucday {
	public static void main(String[] args) {
		int age = checkInput("Enter your age: ");

		LocalTime minimumSleepHours = getAverageSleepDurationByAge(age);
		System.out.println("Minimum sleep hours --> " + minimumSleepHours.getHour() + " hours"
				+ (minimumSleepHours.getMinute() > 0 ? ", " + minimumSleepHours.getMinute() + " minutes" : ""));

		System.out.println("=========================================");

		LocalTime sleptTime = getSleptTime();

		LocalTime startedSleepTime = getBedTime();

		LocalTime wakeUpTime = getWakeUpTime(startedSleepTime, minimumSleepHours, sleptTime);
		System.out.println("--> You should get up at " + wakeUpTime + " AM");
	}

	private static LocalTime getWakeUpTime(LocalTime startedSleepHours, LocalTime minimumSleepHours,
			LocalTime sleptTime) {
		Duration remainingSleepTime = Duration.between(sleptTime, minimumSleepHours);
		System.out.println("Remaining time to sleep --> " + remainingSleepTime);

		int remainingSleepHours = remainingSleepTime.toHoursPart();
		int remainingSleepMinutess = remainingSleepTime.toMinutesPart();

		return startedSleepHours.plusHours(remainingSleepHours).plusMinutes(remainingSleepMinutess);
	}

	private static LocalTime getSleptTime() {
		System.out.println("--- Enter the sleep duration for the day ---");
		int sleptHours = checkInput("+ Hour(s): ");
		int sleptMinutes = checkInput("+ Minute(s): ");
		return LocalTime.of(sleptHours, sleptMinutes);
	}

	private static LocalTime getBedTime() {
		System.out.println("--- Enter the bedtime ---");
		int startedSleepHours = checkInput("+ Hour(s): ");
		int startedSleepMinutes = checkInput("+ Minute(s): ");
		return LocalTime.of(startedSleepHours, startedSleepMinutes);
	}

	private static LocalTime getAverageSleepDurationByAge(int age) {
		if (age >= 1 && age <= 3) {
			return LocalTime.of(20, 0);
		}
		if (age >= 4 && age <= 13) {
			return LocalTime.of(11, 0);
		}
		if (age >= 14 && age <= 17) {
			return LocalTime.of(9, 0);
		}
		if (age >= 18 && age <= 64) {
			return LocalTime.of(8, 0);
		}
		if (age >= 65) {
			return LocalTime.of(7, 30);
		}
		return LocalTime.of(7, 0); // default value
	}
}