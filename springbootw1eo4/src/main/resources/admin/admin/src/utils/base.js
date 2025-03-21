const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootw1eo4/",
            name: "springbootw1eo4",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootw1eo4/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "农产品商城"
        } 
    }
}
export default base
