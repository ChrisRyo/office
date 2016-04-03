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
      return [
        {
          col: "seq",
          friendly: "流水號",
          unique: true,
          hidden: true,
          noPicker : true,
          nonsearch: "nosend",
          nonedit: true
        },
        {
          col: "type",
          friendly: "類別",
          inputsource: "select2",
          menu_path: "querynewstype"
        },
        {
          col: "title",
          friendly: "標題",
        },
        {
          col: "contents",
          friendly: "內容",
          inputsource: "textarea",
          textarea_height: "4",
        },
        {
          col: "creatTime",
          friendly: "新增時間",
          inputsource: "date-range",
          nonedit: "nosend",
        },
        {
          col: "creatUid",
          friendly: "新增人員",
          nonedit: "nosend",
        },
        {
          col: "updateTime",
          friendly: "修改時間",
          inputsource: "date-range",
          nonedit: "nosend",
        },
        {
          col: "updateTime",
          friendly: "修改人員",
          nonedit: "nosend",
        }
      ]
    },
  }
}();