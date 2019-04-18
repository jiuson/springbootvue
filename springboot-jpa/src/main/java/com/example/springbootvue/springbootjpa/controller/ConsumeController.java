package com.example.springbootvue.springbootjpa.controller;

import com.example.springbootvue.springbootjpa.domain.TbConsume;
import com.example.springbootvue.springbootjpa.mvcbase.BaseController;
import com.example.springbootvue.springbootjpa.mvcbase.ControllerResponseCode;
import com.example.springbootvue.springbootjpa.mvcbase.GeneralException;
import com.example.springbootvue.springbootjpa.mvcbase.ResponseResult;
import com.example.springbootvue.springbootjpa.repository.ConsumeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Predicate;
import java.util.Map;
import java.util.Optional;

/**
 * @program: springboot-jpa
 * @descripttion: consume controller
 * @author: jiuson
 * @create: 2019-04-16 19:24:31
 */

@RestController
@RequestMapping("/consume")
@Slf4j
public class ConsumeController extends BaseController {

    @Autowired
    private ConsumeRepository consumeRepository;

    /**
     * 获取消费明细
     * @param pageable
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    @GetMapping
    public ResponseResult<Page<TbConsume>> getConsumeListPage(@PageableDefault(sort = {"consumeDate", "id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                                              @RequestParam(required = false) final String startDate,
                                                              @RequestParam(required = false) final String endDate){

        Page<TbConsume> tbConsumePage = consumeRepository.findAll(((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNotNull(root.get("id"));

            if (null != startDate && null != endDate){
                Predicate predicate1 = criteriaBuilder.greaterThanOrEqualTo(root.get("consumeDate"), startDate);
                Predicate predicate2 = criteriaBuilder.lessThanOrEqualTo(root.get("consumeDate"), endDate);
                predicate = criteriaBuilder.and(predicate, predicate1, predicate2);
            }else if(null != startDate && null == endDate){
                Predicate predicate1 = criteriaBuilder.greaterThanOrEqualTo(root.get("consumeDate"), startDate);
                predicate = criteriaBuilder.and(predicate, predicate1);
            }else if(null == startDate && null != endDate){
                Predicate predicate1 = criteriaBuilder.lessThanOrEqualTo(root.get("consumeDate"), endDate);
                predicate = criteriaBuilder.and(predicate, predicate1);
            }

            return predicate;
        }), pageable);

        return ResponseResult.success(tbConsumePage);
    }

    /**
     * 新增消费记录
     * @param input
     *      consumeName 消费名称
     *      expenditure 消费金额
     *      consumeType 消费类型
     *      consumeDate 消费时间
     * @return
     */
    @PostMapping
    public ResponseResult<Object> createConsumeRecord(@RequestBody Map<String, Object> input){

        TbConsume consume = new TbConsume();

        consume.create((String) input.get("consumeName"), Float.parseFloat((String) input.get("expenditure")), (String) input.get("consumeType"), (Long) input.get("consumeDate"));

        consumeRepository.save(consume);

        return ResponseResult.success(null);
    }

    /**
     * 修改指定id的消费记录
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseResult<Object> modifyConsumeRecord(@PathVariable final Long id,
                                                      @RequestBody Map<String, Object> input){

        Optional<TbConsume> consumeOptional = consumeRepository.findOne((root, criteriaQuery, criteriaBuilder) -> {
           Predicate predicate = criteriaBuilder.equal(root.get("id"), id);
           return predicate;
        });
        if (consumeOptional.isPresent()){
            TbConsume consume = consumeOptional.get();
            consume.modify((String) input.get("consumeName"), Float.parseFloat((String) input.get("expenditure")), (String) input.get("consumeType"), (Long) input.get("consumeDate"));
            consumeRepository.save(consume);
        }else {
            throw new GeneralException(ControllerResponseCode.DATA_NOT_EXIST_CODE, ControllerResponseCode.PARAM_VERIFY_ERROR_MESSAGE);
        }
        return ResponseResult.success(null);
    }

    /**
     * 查询指定id的消费记录
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult<TbConsume> queryConsumeRecordById(@PathVariable final Long id){

        TbConsume consume = null;

        Optional<TbConsume> consumeOptional = consumeRepository.findById(id);

        if (consumeOptional.isPresent()){
            consume = consumeOptional.get();
        }else {
            throw new GeneralException(ControllerResponseCode.DATA_NOT_EXIST_CODE, ControllerResponseCode.DATA_NOT_EXIST_MESSAGE);
        }

        return ResponseResult.success(consume);
    }

    /**
     * 删除指定id的消费记录
     * @param id
     * @return
     */
    @PostMapping("/{id}")
    public ResponseResult<Object> deleteConsumeRecordById(@PathVariable final Long id){

        Optional<TbConsume> consumeOptional = consumeRepository.findById(id);

        if (consumeOptional.isPresent()){
            consumeRepository.deleteById(id);
        }else {
            throw new GeneralException(ControllerResponseCode.DATA_NOT_EXIST_CODE, ControllerResponseCode.DATA_NOT_EXIST_MESSAGE);
        }

        return ResponseResult.success(null);
    }
}
