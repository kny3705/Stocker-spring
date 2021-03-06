export async function getResponseJSON(uri, init) {
	return fetch(uri, init).then(res => res.json())
}

export function getRequestInit(param) {
	return {
		method: 'post',
		headers: {
			'content-type': 'application/json'
		},
		body: JSON.stringify(param)
	}
}