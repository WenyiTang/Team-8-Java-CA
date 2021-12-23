package sg.edu.iss.team8.leaveApp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OvertimeHours {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer overtimeId;
	private LocalDate date;
	private Double hours;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private Employee employee;
}