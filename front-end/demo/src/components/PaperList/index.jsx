import React, { Component } from 'react';
import {withRouter} from 'react-router-dom';
import './index.css'
import { Button, Pagination } from 'antd';

class PaperList extends Component {
    constructor(props) {
        super(props);
        this.state = {

        };
    }

    componentDidMount () {
        console.log(3)
    }

    pageChange = (Pagination) => {
        console.log(Pagination)
    }

    interPaper= () => {
        this.props.history.push('/papercontent');
    }

    render() {
        return (
            <section className="paper-list">
                <ul className="paper-ul">
                    <li className="paper-list-item">
                        <span className="item-name">试卷2222</span>
                        <div className="item-operation">
                            <span className="item-tip">已完成</span>
                            <Button type="primary" onClick={this.interPaper}>查阅</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷1</span>
                        <div className="item-operation">
                            <span className="item-tip">已完成</span>
                            <Button type="primary">查阅</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷2222</span>
                        <div className="item-operation">
                            <span className="item-tip">已完成</span>
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
                            <span className="item-tip">已完成</span>
                            <Button type="primary">查阅</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷1</span>
                        <div className="item-operation">
                            <span className="item-tip">已完成</span>
                            <Button type="primary">查阅</Button>
                        </div>
                    </li>
                    <li className="paper-list-item">
                        <span className="item-name">试卷2222</span>
                        <div className="item-operation">
                            <span className="item-tip">已完成</span>
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