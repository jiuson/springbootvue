/**
 * 将时间戳格式化成日期
 * @param row
 * @param column
 * @param cellValue
 * @param index
 * @returns {string}
 */
export function paseDate(row, column, cellValue, index){
  let datetime = parseInt(row[column.property]);
  let date = new Date(datetime).toLocaleString().replace(/:\d{1,2}$/,' ');
  return date;
}
