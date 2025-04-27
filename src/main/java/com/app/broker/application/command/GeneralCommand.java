package com.app.broker.application.command;

public interface GeneralCommand<ReturnType,ParamType> {
    ReturnType execute(ParamType p);
}
