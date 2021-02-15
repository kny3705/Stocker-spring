export function checkValidityAll(fieldList) {
	console.log(fieldList)
	const invalidiField = fieldList.find(field => !field.checkValidity())
	
	if(!invalidiField) return true
	
	invalidiField.focus()
	invalidiField.reportValidity()
	return false
}