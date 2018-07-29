import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
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
        this.getPaperList(1);
    }

    getPaperList = (page) => {
        fetch('/exam/papers/?currentPage=' + page + '&pageSize=2', {
            method: 'GET'
        })
            .then((res)=>{
                return res.json()
            })
            .then((res)=>{
                this.setState({
                    paperObj:res
                })
            })
    }

    pageChange = (Pagination) => {
        this.getPaperList(Pagination);
    }

    interPaper= (paperId) => {
        this.props.history.push('/papercontent/' + paperId);
    }

    render() {
        let {paperObj}=this.state;
        let This=this;

        return (
            <section className="paper-list">
                <ul className="paper-ul">
                    {
                        paperObj&&paperObj.data?(
                            paperObj.data.map( (item) =>{
                                return(
                                    <li className="paper-list-item" key={item.id}>
                                        <span className="item-name">{item.name}</span>
                                        <div className="item-operation">
                                            <span className="item-tip">{item.isFinished ? item.price : ""}</span>
                                            <Button type="primary" disabled={item.isFinished?true:false} onClick={()=>This.interPaper(item.id)}>{item.isFinished ? "已答题" : "答题"}</Button>
                                        </div>
                                    </li>
                                )
                            })
                        ):("")

                    }
                </ul>
                <Pagination defaultCurrent={1} defaultPageSize={2} total={ paperObj.total } onChange={this.pageChange}/>
            </section>
        );
    }
}

export default withRouter(PaperList);