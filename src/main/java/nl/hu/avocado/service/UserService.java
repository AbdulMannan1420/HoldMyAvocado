package nl.hu.avocado.service;

import jakarta.transaction.Transactional;
import nl.hu.avocado.controller.dto.UserDTO;
import nl.hu.avocado.data.UserRepository;
import nl.hu.avocado.domain.Report;
import nl.hu.avocado.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService {

    private final ReportService reportService;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, ReportService reportService) {
        this.userRepository = userRepository;
        this.reportService = reportService;
    }

    public User dtoIntoUser(UserDTO dto) {
        List<Report> reports = new ArrayList<>();
        for (Long f : dto.getReports()) {
            reports.add(reportService.dtoIntoReport(this.reportService.findReportById(f)));
        }
        return new User(dto.getId(), dto.getVoornaam(), dto.getEmail(), reports);
    }

    public void addUser(UserDTO userDTO) {
        User user = dtoIntoUser(userDTO);
        userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
