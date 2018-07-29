import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import './index.css'

import { Form, Icon, Input, Button, message } from 'antd';

const FormItem = Form.Item;

class NormalLoginForm extends React.Component {
    handleSubmit = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                fetch('/user/login?username=' + values.userName + '&password=' + values.password, {
                    method: 'GET'
                })
                    .then((res)=>{
                        return res.text()
                    })
                    .then((res)=>{
                        if(res === "用户不存在！" || res === "密码错误！") {
                            message.error(res);
                        } else {
                            this.props.history.push('/paperlist');
                        }
                    })
            }
        });

    }

    render() {
        const { getFieldDecorator } = this.props.form;
        return (
            <Form onSubmit={this.handleSubmit} className="login-form">
                <FormItem>
                    {getFieldDecorator('userName', {
                        rules: [{ required: true, message: '请输入用户名!' }],
                    })(
                        <Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />} placeholder="Username" />
                    )}
                </FormItem>
                <FormItem>
                    {getFieldDecorator('password', {
                        rules: [{ required: true, message: '请输入密码!' }],
                    })(
                        <Input prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />} type="password" placeholder="Password" />
                    )}
                </FormItem>
                <FormItem>
                    <Button type="primary" htmlType="submit" className="login-form-button">
                        登录
                    </Button>
                </FormItem>
            </Form>
        );
    }
}

const WrappedNormalLoginForm = Form.create()(withRouter(NormalLoginForm));

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {

        };
    }

    componentDidMount () {

    }

    render() {
        return (
            <section className="App-login">
                <section className="App-login-content">
                    <section className="App-login-left">WELCOME TO 555</section>
                    <div className="App-login-form">
                        <WrappedNormalLoginForm></WrappedNormalLoginForm>
                    </div>
                </section>
            </section>
        );
    }
}

export default Login;