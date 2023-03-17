package com.example.university.Subject;

import com.example.university.Exception.SubjectException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServices {
    private final SubjectRepository subjectRepository;

    private final SubjectMapper subjectMapper;

    public SubjectServices(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }
    SubjectDto saveSubject(SubjectDto dto){
        subjectRepository.findBySubjectIgnoreCase(dto.getSubject())
                .ifPresent(subject -> {throw new SubjectException();
                });
        Subject mapped = subjectMapper.map(dto);
        Subject save = subjectRepository.save(mapped);
        return subjectMapper.map(save);
    }
    List<SubjectDto>findAll(){
        return subjectRepository.findAll().stream()
                .map(subjectMapper::map).toList();
    }
@Transactional
    public void deleteByName(String name){
        subjectRepository.deleteBySubjectIgnoreCase(name);
}

}
