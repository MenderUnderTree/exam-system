package com.thoughtworks.examsystem.exception;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.exception
 */
public class PaperHasBeenFinishedException extends BadRequestException {
    @Override
    public int getCode() {
        return 4001;
    }

    @Override
    public String getDescription() {
        return "Paper has been finished";
    }

}
