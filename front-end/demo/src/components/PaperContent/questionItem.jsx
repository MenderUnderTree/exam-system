import React, { Component } from 'react';
import { Radio } from 'antd'

const RadioGroup = Radio.Group;

class QuestionItem extends Component {

  _onRadioChange () {

  }

    render() {
      const { index, description, points, ispreview, anwsers } = this.props
      const anwserOptions = anwsers.map((e, i) => {
        return {
          label: `${String.fromCharCode(i+97)}. ${e}`,
          value: i, 
          disabled: ispreview
        }
      })

        return (
            <div className='question-item'>
                <label className='question-title'>{`${index+1}. ${description} (${points}分)`}</label>
                <RadioGroup options={anwserOptions} onChange={this._onRadioChange} />
            </div>
        );
    }
}

export default QuestionItem;