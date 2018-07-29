import React, { Component } from 'react';
import {withRouter} from 'react-router-dom';
import './index.css'
import { Button, Pagination } from 'antd';

class PaperList extends Component {
    constructor(props) {
        super(props);
        this.state = {
           paperObj:{}
        };
    }

    componentDidMount () {
        let This = this;
        fetch('http://www.realks.win:8086/exam/papers/?currentPage=1&pageSize=5', {
            method: 'GET'
        })
            .then((res)=>{
                This.setState({
                    paperObj:res
                })
            })
            .then((res)=>{
                console.log(res)
            })
    }

    pageChange = (Pagination) => {
        console.log(Pagination)
    }

    interPaper= () => {
        this.props.history.push('/papercontent/1');
    }

    render() {
        let {paperObj}=this.state;
        return (
            <section className="paper-list">
                <ul className="paper-ul">
                    {
                        paperObj&&paperObj.data?(
                            paperObj.data.map(function (item,index) {
                                return(
                                    <li className="paper-list-item" key={item.id}>
                                        <span className="item-name">{item.name}</span>
                                        <div className="item-operation">
                                            <span className="item-tip">{item.isFinished ? item.price : ""}</span>
                                            <Button type="primary" onClick={this.interPaper}>{item.isFinished ? "查阅" : "答题"}</Button>
                                        </div>
                                    </li>
                                )
                            })
                        ):("")

                    }
                    <li className="paper-list-item">
                        <span className="item-name">试卷2222</span>
                        <div className="item-operation">
                            <span className="item-tip">86</span>
                            <Button type="primary" onClick={this.interPaper}>查阅</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷1</span>
                        <div className="item-operation">
                            <span className="item-tip">86</span>
                            <Button type="primary">查阅</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷2222</span>
                        <div className="item-operation">
                            <span className="item-tip">86</span>
                            <Button type="primary">查阅</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷1</span>
                        <div className="item-operation">
                            <span className="item-tip"></span>
                            <Button type="primary">答题</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷2222</span>
                        <div className="item-operation">
                            <span className="item-tip">86</span>
                            <Button type="primary">查阅</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷1</span>
                        <div className="item-operation">
                            <span className="item-tip">86</span>
                            <Button type="primary">查阅</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷2222</span>
                        <div className="item-operation">
                            <span className="item-tip">86</span>
                            <Button type="primary">查阅</Button>
                        </div>
                    </li>
                </ul>
                <Pagination defaultCurrent={6} total={500} onChange={this.pageChange}/>
            </section>
        );
    }
}

export default withRouter(PaperList);