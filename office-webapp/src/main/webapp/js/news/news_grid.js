/**
 * chrisryo
 */
var NewsGrid = function() {
  return {

    id: "gridNews",
    url: "/news/query",
    watable: new Object(),
    title: "公告列表",

    coldefs: function() {
      return {
        seq: {
          friendly: "流水號",
          unique: true,
          hidden: true,
          noPicker : true,
          nonsearch: "nosend",
          nonedit: true
        },
        type: {
          friendly: "類別",
          inputsource: "select2",
          menu_path: "querynewstype"
        },
        title: {
          friendly: "標題",
        },
        contents: {
          friendly: "內容",
          inputsource: "textarea",
          textarea_height: "4",
        },
        creatTime: {
          friendly: "新增時間",
          inputsource: "date-range",
          nonedit: "nosend",
        },
        creatUid: {
          friendly: "新增人員",
          nonedit: "nosend",
        },
        updateTime: {
          friendly: "修改時間",
          inputsource: "date-range",
          nonedit: "nosend",
        },
        updateUid: {
          friendly: "修改人員",
          nonedit: "nosend",
        }
      }
    },
  }
}();