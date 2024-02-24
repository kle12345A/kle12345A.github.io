using Microsoft.AspNetCore.Mvc;

namespace Lesson01.MVC.Controllers
{
    public class DemoController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
